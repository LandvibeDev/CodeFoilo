package com.landvibe.codefolio.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(WebSecurity web) throws Exception {
        /**
         *  리소스 추가
         */
        web.ignoring().antMatchers(
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

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/", "/main","/auth").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginProcessingUrl("/login")
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
    }
}
