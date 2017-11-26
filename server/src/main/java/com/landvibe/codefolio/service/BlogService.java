package com.landvibe.codefolio.service;

import com.landvibe.codefolio.error.NotFoundException;
import com.landvibe.codefolio.model.Blog;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.repository.BlogRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PostAuthorize;
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

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public List<Blog> getBlogsByUserId(long id) {
        return blogRepository.findBlogsByCreatorId(id);
    }

    public Blog getBlog(long id) {
        Blog blog = blogRepository.findOne(id);
        if (blog == null) {
            throw new NotFoundException("해당 게시물은 존재하지 않습니다..");
        }
        return blog;
    }

    @Transactional
    public Blog createBlog(Blog blog, User creator) {
        blog.setCreator(creator);
        return blogRepository.save(blog);
    }

    @Transactional
    public Blog updateBlog(User user, long id, Blog newBlog) {
        Blog blog = blogRepository.findOne(id);
        if (blog == null) {
            throw new NotFoundException("해당 게시물은 존재하지 않습니다..");
        }
        if (user.getId() != blog.getCreator().getId()) {
            throw new AccessDeniedException("해당 게시물을 수정할 수 있는 권한이 없습니다.");
        }
        blog.updateBlog(newBlog);
        return blogRepository.save(blog);
    }

    @Transactional
    public void deleteBlog(User user, long id) {
        Blog blog = blogRepository.findOne(id);
        if (blog == null) {
            throw new NotFoundException("해당 게시물은 존재하지 않습니다..");
        }
        if (user.getId() != blog.getCreator().getId()) {
            throw new AccessDeniedException("해당 게시물을 수정할 수 있는 권한이 없습니다.");
        }
        blogRepository.delete(blog);
    }
}
