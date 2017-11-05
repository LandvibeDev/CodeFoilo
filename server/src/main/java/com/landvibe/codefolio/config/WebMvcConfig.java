package com.landvibe.codefolio.config;

import com.landvibe.codefolio.config.resolver.CurrentUserHandlerMethodArgumentResolver;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private ResourceProperties resourceProperties = new ResourceProperties();

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        /**
         * resolver 생성시 이곳에 bean 객체를 만들고 argumentResolvers에 add 해줄 것
         */
        argumentResolvers.add(currentUserHandlerMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public CurrentUserHandlerMethodArgumentResolver currentUserHandlerMethodArgumentResolver(){
        return new CurrentUserHandlerMethodArgumentResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticPathPatterns[] = new String[]{
                "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.swf", "/**/*.csv", "/**/*.css", "/**/*.html", "/**/*.gif",
                "/**/*.ico", "/**/*.woff", "/**/*.woff2", "/**/*.ttf","/**/*.json"
        };
        Integer cachePeriod = this.resourceProperties.getCachePeriod();
        registry.addResourceHandler(staticPathPatterns)
                .addResourceLocations(this.resourceProperties.getStaticLocations())
                .setCachePeriod(cachePeriod);
    }

}
