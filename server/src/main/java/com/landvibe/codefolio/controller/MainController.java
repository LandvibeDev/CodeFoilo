package com.landvibe.codefolio.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/main")
    public String main(@CurrentUser User user) {
        if (user == null) {
            logger.info("Anonymous user accessed the main page");
        } else {
            logger.info(user.getUsername() + " accessed the main page");
        }
        return "app";
    }
}
