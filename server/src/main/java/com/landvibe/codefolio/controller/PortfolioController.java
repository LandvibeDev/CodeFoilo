package com.landvibe.codefolio.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    private Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @GetMapping("/portfolio")
    public String portfolio(@CurrentUser User user) {
        if (user == null) {
            return "redirect:/login/github";
        }

        logger.info(user.getUsername() + "'s portfolio");
        return "app";
    }

    @GetMapping("/github")
    public String github(@CurrentUser User user) {
        if (user == null) {
            return "redirect:/login/github";
        }

        logger.info(user.getUsername() + "'s github data");
        return "app";
    }
}
