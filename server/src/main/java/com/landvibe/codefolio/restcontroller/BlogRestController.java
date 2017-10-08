package com.landvibe.codefolio.restcontroller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs(@CurrentUser User user) {
        List<Blog> blogs = blogService.getAllBlogList();
        return blogs;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping("/api/blogs")
    public Blog createBlog(@CurrentUser User user, @RequestBody Blog blog) {
        return blogService.createBlog(blog, user);
    }
}
