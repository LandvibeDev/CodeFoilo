package com.landvibe.codefolio.github.repository;

import com.landvibe.codefolio.github.model.GitHubData;
import com.landvibe.codefolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GItHubDataRepository extends JpaRepository<GitHubData, Long> {

    GitHubData findByUser_Username(String username);
}
