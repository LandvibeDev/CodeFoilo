package com.landvibe.codefolio.github.model;

import com.landvibe.codefolio.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class GitHubData implements Serializable {

    private static final long serialVersionUID = 9093162354050890204L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(targetEntity = GitHubRepository.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "github_repos",
            joinColumns = @JoinColumn(name = "repository_id"),
            inverseJoinColumns = @JoinColumn(name = "github_data_id"))
    private List<GitHubRepository> repositories = new ArrayList<>();

    @ManyToMany(targetEntity = GitHubOrganization.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "github_orgs",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "github_data_id"))
    private List<GitHubOrganization> organizations = new ArrayList<>();

    @ManyToMany(targetEntity = GitHubEvent.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "github_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "github_data_id"))
    private List<GitHubEvent> events = new ArrayList<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected GitHubData() {
    }

    public GitHubData(List<GitHubRepository> repositories, List<GitHubOrganization> organizations, List<GitHubEvent> events, User user) {
        this.repositories = repositories;
        this.organizations = organizations;
        this.events = events;
        this.user = user;
    }
}
