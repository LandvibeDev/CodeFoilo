package com.landvibe.codefolio.repository;

import com.landvibe.codefolio.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneByUsername(String username);
}
