package com.landvibe.codefolio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/main")
    public String main() {
        return "app";
    }
}
