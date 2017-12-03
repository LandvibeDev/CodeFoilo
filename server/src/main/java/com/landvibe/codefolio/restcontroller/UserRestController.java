package com.landvibe.codefolio.restcontroller;

import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/api/user/")
    public User getUser(@RequestParam String username) {
        return userService.loadUserByUsername(username);
    }
}
