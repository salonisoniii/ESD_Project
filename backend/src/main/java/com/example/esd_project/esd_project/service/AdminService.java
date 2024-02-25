package com.example.esd_project.esd_project.service;
import com.example.esd_project.esd_project.DTO.Login;
import com.example.esd_project.esd_project.DTO.LoginMessage;
import com.example.esd_project.esd_project.model.Admin;
import com.example.esd_project.esd_project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveAdmin(Admin adminData) {
        String encodedPassword = this.passwordEncoder.encode(adminData.getPassword());
        adminData.setPassword((encodedPassword));
        adminRepository.save(adminData);
    }

    public LoginMessage loginEmployee(Login login) {
        String msg = "";

        Admin adminFromRequest = adminRepository.findByEmail(login.getEmail());
        if (!adminFromRequest.getDept().equals("1")) {
            return new LoginMessage("not allowed to login", false);
        } else {
            if (adminFromRequest != null) {
                String passwordFromRequest = login.getPassword();
                String passwordFromAdmin = adminFromRequest.getPassword();
                Boolean isPwdRight = passwordEncoder.matches(passwordFromRequest, passwordFromAdmin);
                if (isPwdRight) {
                    Optional<Admin> admin = adminRepository.findOneByEmailAndPassword(login.getEmail(), passwordFromAdmin);
                    if (admin.isPresent()) {
                        return new LoginMessage("Login Success", true);
                    }
                    else {
                        return new LoginMessage("Login failed", false);
                    }
                }
                else {
                    return new LoginMessage("Password not match", false);
                }
            }
            else {
                return new LoginMessage("Email not exits", false);
            }
        }
    }

    public boolean existsByEmail(String email) {
        return adminRepository.existsByEmail(email);
    }
}