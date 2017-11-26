package com.landvibe.codefolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Getter
@Setter
@ToString
@Entity
public class Blog implements Serializable {

    private static final long serialVersionUID = -4350784958370090422L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String contents;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    protected Blog() {
        initTimes();
    }

    public Blog(String title, String contents) {
        this.title = title;
        this.contents = contents;
        initTimes();
    }

    public Blog(String title, String contents, Calendar createdAt, Calendar updatedAt, User creator) {
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.creator = creator;
    }

    private void initTimes() {
        this.createdAt = Calendar.getInstance();
        this.updatedAt = this.createdAt;
    }

    public void updateBlog(Blog blog) {
        this.title = blog.getTitle();
        this.contents = blog.getContents();
        this.updatedAt = Calendar.getInstance();
    }

}
