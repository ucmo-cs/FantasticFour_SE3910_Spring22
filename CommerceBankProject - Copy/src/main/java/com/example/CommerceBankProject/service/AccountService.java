package com.example.CommerceBankProject.service;

import com.example.CommerceBankProject.domain.Account;
import com.example.CommerceBankProject.domain.OpenSource;
import com.example.CommerceBankProject.repository.OpenSourceRepository;
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
                .orElseThrow(() -> new ClassNotFoundException("Account not found for this id :: " + accountId));
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Account deleted", Boolean.TRUE);
        return response;
    }
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
    //
    //beginning of open source
    //
    private final OpenSourceRepository openSourceRepository;
    @Transactional
    public OpenSource createOpenSource(OpenSource openSource, Long accountId){
        //Date date = new Date();
        //Account id = accountRepository.getById(accountId);
        //Long idNum = id.getId();
        //openSource.setAccountID(String.valueOf(idNum));
        //openSource.setDateRequested(date);
        //openSource.setStatus(false);
        return openSourceRepository.save(openSource);
    }
    @Transactional
    public Map<String, Boolean> deleteOpenSource(@PathVariable(value = "id") Long openSourceId)
            throws ClassNotFoundException {
        OpenSource openSource = openSourceRepository.findById(openSourceId)
                .orElseThrow(() -> new ClassNotFoundException("Open Source not found for this id :: " + openSourceId));
        openSourceRepository.delete(openSource);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Open source deleted", Boolean.TRUE);
        return response;
    }
    public List<OpenSource> findAllOpenSource(){
        return openSourceRepository.findAll();
    }
}
