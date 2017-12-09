package com.landvibe.codefolio.github.service;

import com.landvibe.codefolio.github.model.GitHubData;
import com.landvibe.codefolio.github.model.GitHubEvent;
import com.landvibe.codefolio.github.model.GitHubOrganization;
import com.landvibe.codefolio.github.model.GitHubRepository;
import com.landvibe.codefolio.github.repository.GItHubDataRepository;
import com.landvibe.codefolio.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class GitHubService {

    private GItHubDataRepository gItHubDataRepository;

    public GitHubService(GItHubDataRepository gItHubDataRepository) {
        this.gItHubDataRepository = gItHubDataRepository;
    }

    @Transactional
    public void updateRepos(User user, List<GitHubRepository> repositories) {
        GitHubData gitHubData = gItHubDataRepository.findByUser_Username(user.getUsername());
        gitHubData.setRepositories(repositories);
    }

    @Transactional
    public void updateOrgs(User user, List<GitHubOrganization> organizations) {
        GitHubData gitHubData = gItHubDataRepository.findByUser_Username(user.getUsername());
        gitHubData.setOrganizations(organizations);
    }

    @Transactional
    public void updateEvents(User user, List<GitHubEvent> events) {
        GitHubData gitHubData = gItHubDataRepository.findByUser_Username(user.getUsername());
        gitHubData.setEvents(events);
    }

}
