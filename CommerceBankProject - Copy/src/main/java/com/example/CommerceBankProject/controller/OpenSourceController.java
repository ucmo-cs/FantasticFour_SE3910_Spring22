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
    @GetMapping("/open_sources/{status}")
    public ResponseEntity<?> findAllOpenSourcesStatus(@PathVariable int status) throws Exception
    {return new ResponseEntity<>(openSourceService.listInProgressOpenSource(status), HttpStatus.OK);}
    @PostMapping("/open_sources/create/{accountId}")
    public ResponseEntity<?> saveOpenSource
            (@RequestBody OpenSource openSource, @PathVariable String accountId)
            throws ClassNotFoundException {
        return new ResponseEntity<>(openSourceService.createOpenSource(openSource,
                        Long.valueOf(accountId)), HttpStatus.CREATED);
    }
    @DeleteMapping("/open_sources/delete/{projnumber}/{accnumber}")
    public ResponseEntity<?> deleteOpenSource
            (@PathVariable("projnumber") Long openSourceId,
             @PathVariable("accnumber") Long accId) throws ClassNotFoundException {
        return new ResponseEntity<>(openSourceService.deleteOpenSource
                (Long.valueOf(openSourceId),Long.valueOf(accId)), HttpStatus.OK);
    }

}
