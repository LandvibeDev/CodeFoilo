package com.landvibe.codefolio.config.security;

import com.landvibe.codefolio.model.User;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserContext {
    /**
     * 현재 Session 사용자의 정보
     * @return current user;
     */
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth ==null){
            throw new AuthenticationCredentialsNotFoundException("No authentication");
        }
        Object object = auth.getPrincipal();
        if("anonymousUser".equals(object)){
            return null;
        }
        if(!(object instanceof User)){
            throw new AuthenticationCredentialsNotFoundException("Invalid authentication with " + object);
        }
        User securedUser = (User) object;
        return securedUser;
    }
}
