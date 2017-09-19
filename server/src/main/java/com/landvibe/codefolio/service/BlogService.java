package com.landvibe.codefolio.service;

import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlogByTitle(String title){
        return blogRepository.findByTitle(title);
    }

    public List<Blog> getAllBlogList(){
        return blogRepository.findAll();
    }

    public Blog createBlog(Blog blog){
        return blogRepository.save(blog);
    }
}
