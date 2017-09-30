package com.landvibe.codefolio.repository;

import com.landvibe.codefolio.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findRoleByName(String name);
}
