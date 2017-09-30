package com.landvibe.codefolio.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String welcome(@CurrentUser User user) {
        if (user == null) {
            logger.info("Welcome anonymous!");
        } else {
            logger.info("Welcome " + user.getUsername());
        }

        return "app";
    }
}
