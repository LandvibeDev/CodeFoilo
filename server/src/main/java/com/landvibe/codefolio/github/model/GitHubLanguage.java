package com.landvibe.codefolio.github.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class GitHubLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String numOfByte;

    protected GitHubLanguage() {
    }

    public GitHubLanguage(String name, String numOfByte) {
        this.name = name;
        this.numOfByte = numOfByte;
    }
}
