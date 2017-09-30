package com.landvibe.codefolio.config.resolver;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.config.security.UserContext;
import com.landvibe.codefolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * 함수 인자의 @CurrentUser를 인식해서 현재 Session의 사용자 정보를 리턴한다
 */
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserContext userContext;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        User currentUser = userContext.getCurrentUser();
        return currentUser;
    }
}
