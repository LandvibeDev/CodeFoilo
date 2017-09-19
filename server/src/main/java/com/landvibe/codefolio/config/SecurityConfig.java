package com.landvibe.codefolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers(
                "/",
                "/main",
                "/**/*.js",
                "/**/*.css",
                "/**/*.png",
                "/**/*.jpg",
                "/**/*.jpeg",
                "/**/*.swf",
                "/**/*.csv",
                "/**/*.gif",
                "/**/*.ico",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.ttf");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}
