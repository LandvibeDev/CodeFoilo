package com.landvibe.codefolio.github.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.github.service.EventService;
import com.landvibe.codefolio.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class GitHubEventApiController {

    private EventService eventService;

    public GitHubEventApiController(EventService eventService) {
        this.eventService = eventService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getUserEvents(@CurrentUser User user) {
        return eventService.getEvents(user.toString());
    }

}
