package com.landvibe.codefolio.service;

import com.landvibe.codefolio.error.NotFoundException;
import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlogByTitle(String title) {
        return blogRepository.findByTitle(title);
    }

    public List<Blog> getAllBlogList() {
        return blogRepository.findAll();
    }

    public Blog getBlogOne(long id){
        return blogRepository.findOne(id);
    }

    @Transactional
    public Blog createBlog(Blog blog, User creator) {
        blog.setCreator(creator);
        return blogRepository.save(blog);
    }

    @Transactional
    public Blog updateBlog(Blog blog) {
        boolean exists = blogRepository.exists(blog.getId());
        if (!exists) {
            throw new NotFoundException("해당 게시물은 존재하지 않습니다..");
        }
        return blogRepository.save(blog);
    }

    @Transactional
    public void deleteBlog(Blog blog) {
        long id = blog.getId();
        boolean exists = blogRepository.exists(id);
        if (!exists) {
            throw new NotFoundException("해당 게시물은 존재하지 않습니다..");
        }
        blogRepository.delete(id);
    }
}
