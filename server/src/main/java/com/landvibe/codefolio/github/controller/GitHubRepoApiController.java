package com.landvibe.codefolio.github.controller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.github.service.RepositoryService;
import com.landvibe.codefolio.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repo")
public class GitHubRepoApiController {

    private RepositoryService repositoryService;

    public GitHubRepoApiController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getUserRepos(@CurrentUser User user) {
        return repositoryService.getRepositories(user.getToken());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "/org", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getOrgRepos(@CurrentUser User user, @RequestParam String org) {
        return repositoryService.getOrgRepositories(org, user.getToken());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getLanguage(@CurrentUser User user, @RequestParam String owner, @RequestParam String repo) {
        return repositoryService.getLanguages(owner, repo, user.getToken());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getTopics(@CurrentUser User user, @RequestParam String owner, @RequestParam String repo) {
        return repositoryService.getTopics(owner, repo, user.getToken());
    }
}
