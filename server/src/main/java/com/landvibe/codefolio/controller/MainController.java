package com.landvibe.codefolio.controller;

import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private BlogService blogService;

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
