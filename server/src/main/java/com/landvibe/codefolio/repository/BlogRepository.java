package com.landvibe.codefolio.repository;

import com.landvibe.codefolio.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTitle(String title);

    List<Blog> findAll();
}
