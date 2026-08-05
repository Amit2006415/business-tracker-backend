package com.businesstracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businesstracker.dto.ChangePasswordRequest;
import com.businesstracker.entity.Admin;
import com.businesstracker.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // =====================================
    // Register
    // =====================================

    public Admin saveAdmin(Admin admin) {

        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (adminRepository.existsByMobile(admin.getMobile())) {
            throw new RuntimeException("Mobile number already exists");
        }

        return adminRepository.save(admin);
    }

    // =====================================
    // Login
    // =====================================

    public boolean login(String email, String password) {

        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            return false;
        }

        return admin.getPassword().equals(password);
    }

    // =====================================
    // Find Admin
    // =====================================

    public Admin findByEmail(String email) {

        return adminRepository.findByEmail(email);

    }

    // =====================================
    // Verify Security Answer
    // =====================================

    public boolean verifySecurityAnswer(String email, String answer) {

        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            return false;
        }

        return admin.getSecurityAnswer()
                .equalsIgnoreCase(answer.trim());

    }

    // =====================================
    // Change Password
    // =====================================

    public String changePassword(ChangePasswordRequest request) {

        Admin admin = adminRepository.findByEmail(request.getEmail());

        if (admin == null) {
            return "Email Not Found";
        }

        admin.setPassword(request.getNewPassword());

        adminRepository.save(admin);

        return "Password Updated Successfully";

    }

}