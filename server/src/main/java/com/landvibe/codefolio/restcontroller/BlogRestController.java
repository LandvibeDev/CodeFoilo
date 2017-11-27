package com.landvibe.codefolio.restcontroller;

import com.landvibe.codefolio.config.annotation.CurrentUser;
import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/api/blog")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Blog> getAllBlog(@CurrentUser User user) {
        return blogService.getAllBlog();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/api/blog/user/{uid}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Blog> getBlogsByUserId(@CurrentUser User user, @PathVariable long uid) {
        return blogService.getBlogsByUserId(uid);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/api/blog/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Blog getBlog(@CurrentUser User user, @PathVariable long id) {
        return blogService.getBlog(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/api/blog")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Blog createBlog(@CurrentUser User user, @RequestBody Blog blog) {
        return blogService.createBlog(blog, user);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PutMapping("/api/blog/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Blog updateBlog(@CurrentUser User user, @PathVariable long id, @RequestBody Blog blog) {
        return blogService.updateBlog(user, id, blog);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @DeleteMapping("/api/blog/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBlog(@CurrentUser User user, @PathVariable long id) {
        blogService.deleteBlog(user, id);
    }
}
