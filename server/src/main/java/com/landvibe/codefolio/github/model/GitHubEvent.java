package com.landvibe.codefolio.github.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Getter
@Setter
@ToString
@Entity
public class GitHubEvent {
    @Id
    private long id;
    private String type;
    private String repoId;
    private String repoName;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar createdAt;

    protected GitHubEvent(){}

    public GitHubEvent(long id, String type, String repoId, String repoName, Calendar createdAt) {
        this.id = id;
        this.type = type;
        this.repoId = repoId;
        this.repoName = repoName;
        this.createdAt = createdAt;
    }
}
