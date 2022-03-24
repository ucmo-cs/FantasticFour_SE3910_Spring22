package com.example.CommerceBankProject.controller;

import com.example.CommerceBankProject.domain.OpenSource;
import com.example.CommerceBankProject.service.OpenSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OpenSourceController {
    private final OpenSourceService openSourceService;
    @GetMapping("/open_sources")
    public ResponseEntity<?> findAllOpenSources(){return new ResponseEntity<>
            (openSourceService.findAllOpenSource(), HttpStatus.OK);}
    @PostMapping("/open_sources/create/{accountId}")
    public ResponseEntity<?> saveOpenSource
            (@RequestBody OpenSource openSource, @PathVariable String accountId)
            throws ClassNotFoundException {
        return new ResponseEntity<>(openSourceService.createOpenSource(openSource,
                        Long.valueOf(accountId)), HttpStatus.CREATED);
    }
}
