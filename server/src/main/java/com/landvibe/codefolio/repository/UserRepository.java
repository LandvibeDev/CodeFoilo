package com.landvibe.codefolio.repository;

import com.landvibe.codefolio.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.username = :userName")
    boolean existsByName(@Param("userName") String userName);
}
