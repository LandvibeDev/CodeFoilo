package com.landvibe.codefolio.service;

import com.landvibe.codefolio.model.Account;
import com.landvibe.codefolio.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(String username) {
        return accountRepository.findOneByUsername(username);
    }
}
