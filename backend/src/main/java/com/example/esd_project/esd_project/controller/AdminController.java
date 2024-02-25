package com.example.esd_project.esd_project.controller;
import com.example.esd_project.esd_project.DTO.Login;
import com.example.esd_project.esd_project.DTO.LoginMessage;
import com.example.esd_project.esd_project.model.Admin;
import com.example.esd_project.esd_project.repository.AdminRepository;
import com.example.esd_project.esd_project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterAdmin(@RequestBody Admin adminData) {
        if(adminService.existsByEmail(adminData.getEmail())){
            return new ResponseEntity<>("Error:Email is already taken,try registering using another email",HttpStatus.BAD_REQUEST);
        }
        adminService.saveAdmin(adminData);
        return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login){
        LoginMessage loginMessage=adminService.loginEmployee(login);
        return ResponseEntity.ok(loginMessage);
    }

}
