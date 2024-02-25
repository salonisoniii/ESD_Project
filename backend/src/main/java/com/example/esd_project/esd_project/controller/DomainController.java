package com.example.esd_project.esd_project.controller;
import com.example.esd_project.esd_project.model.Domain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.esd_project.esd_project.service.DomainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("/create")
    public ResponseEntity<String> createDomain(@RequestBody Domain domainData) {
        domainService.saveDomain(domainData);
        return new ResponseEntity<>("Domain created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public List<Domain>  getDomains(){
        return domainService.getAllDomains();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Domain> getDomainById(@PathVariable Long id) {
        Domain domain = domainService.getDomainById(id);
        if (domain != null) {
            return new ResponseEntity<>(domain, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDomain(@PathVariable Long id, @RequestBody Domain updatedDomainData) {
        domainService.updateDomain(id, updatedDomainData);
        return new ResponseEntity<>("Domain updated successfully", HttpStatus.OK);
    }


}
