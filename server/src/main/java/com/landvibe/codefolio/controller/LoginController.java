package com.landvibe.codefolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "app";
    }

    @GetMapping(value = {"/signup", "/signup/{username}"})
    public String signup() {
        return "app";
    }
}
