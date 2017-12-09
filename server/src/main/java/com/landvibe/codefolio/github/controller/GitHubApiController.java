package com.landvibe.codefolio.github.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.github.model.GitHubEvent;
import com.landvibe.codefolio.github.model.GitHubOrganization;
import com.landvibe.codefolio.github.model.GitHubRepository;
import com.landvibe.codefolio.github.service.GitHubService;
import com.landvibe.codefolio.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GitHubApiController {

    private GitHubService gitHubService;

    public GitHubApiController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PutMapping(value = "/repos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void putRepos(@CurrentUser User user, @RequestBody List<GitHubRepository> repositories) {
        gitHubService.updateRepos(user, repositories);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PutMapping(value = "/orgs", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void putOrgs(@CurrentUser User user, @RequestBody List<GitHubOrganization> organizations) {
        gitHubService.updateOrgs(user, organizations);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PutMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void putEvents(@CurrentUser User user, @RequestBody List<GitHubEvent> events) {
        gitHubService.updateEvents(user, events);
    }
}
