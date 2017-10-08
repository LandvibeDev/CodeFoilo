package com.landvibe.codefolio.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String contents;

    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User creator;

    private Blog(){
        initTimes();
    }

    public Blog(String title, String contents) {
        this.title = title;
        this.contents = contents;
        initTimes();
    }

    public Blog(String title, String contents, Date createdAt, Date updatedAt, User creator) {
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.creator = creator;
    }

    private void initTimes(){
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

}
