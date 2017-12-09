package com.landvibe.codefolio.github.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class GitHubRepository {

    @Id
    private long id;
    private String name;
    private String fullName;
    private String description;
    private String url;
    private int starsCount;
    private int watcherCount;

    @ManyToMany(targetEntity = GitHubLanguage.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "repo_lang",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "repo_id"))
    private List<GitHubLanguage> languages = new ArrayList<>();

    @ElementCollection
    private List<String> topics = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar updatedAt;

    protected GitHubRepository() {
    }

    public GitHubRepository(long id, String name, String fullName, String description, String url, int starsCount, int watcherCount, Calendar createdAt, Calendar updatedAt, List<String> topics, List<GitHubLanguage> languages) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.url = url;
        this.starsCount = starsCount;
        this.watcherCount = watcherCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.topics = topics;
        this.languages = languages;
    }
}
