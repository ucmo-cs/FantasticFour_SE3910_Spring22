package com.example.CommerceBankProject.service;

import com.example.CommerceBankProject.domain.Account;
import com.example.CommerceBankProject.repository.accountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final accountRepository accountRepository;
    @Transactional
    public Account create(Account account){
        return accountRepository.save(account);
    }
    @Transactional
    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId)
            throws ClassNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ClassNotFoundException("Account not found for this" +
                        " id :: " + accountId));
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Account deleted", Boolean.TRUE);
        return response;
    }
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}
