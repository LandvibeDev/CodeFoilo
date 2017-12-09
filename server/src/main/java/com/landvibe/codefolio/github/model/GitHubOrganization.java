package com.landvibe.codefolio.github.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class GitHubOrganization {

    @Id
    private long id;
    private String name;
    private String url;
    private String description;

    protected GitHubOrganization(){}

    public GitHubOrganization(long id, String name, String url, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
    }
}
