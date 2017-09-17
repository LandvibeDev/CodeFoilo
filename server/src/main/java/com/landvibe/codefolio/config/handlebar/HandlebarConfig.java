package com.landvibe.codefolio.config.handlebar;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import java.util.HashMap;

@Configuration
public class HandlebarConfig {

    @Value("${codefolio.dev-mode}")
    private boolean devMode;

    @Value("${server.context-path}")
    private String contextPath;

    @Bean
    public ViewResolver viewResolver(){
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
        viewResolver.setCache(!devMode);
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".html");
        HashMap<String, String> defaultAttrs = new HashMap<>();
        defaultAttrs.put("contextPath",contextPath);
        return viewResolver;
    }
}
