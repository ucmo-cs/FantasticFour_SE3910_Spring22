package com.example.CommerceBankProject.controller;

import com.example.CommerceBankProject.domain.Account;
import com.example.CommerceBankProject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }
    @PostMapping("/account")
    public ResponseEntity<?> save (@RequestBody Account account){
        return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);
    }
    @DeleteMapping(value ="/accounts/{id}")
    public ResponseEntity<?>remove(@PathVariable String id) throws ClassNotFoundException {
        return new ResponseEntity<>(accountService.deleteAccount(Long.valueOf(id)), HttpStatus.OK);
    }
    @GetMapping("/accounts")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>
                (accountService.findAll(), HttpStatus.OK);
    }
}

