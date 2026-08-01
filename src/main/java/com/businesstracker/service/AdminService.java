package com.businesstracker.service;

import com.businesstracker.dto.ChangePasswordRequest;
import com.businesstracker.entity.Admin;
import com.businesstracker.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Login
    public boolean login(String email, String password) {

        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            return false;
        }

        return admin.getPassword().equals(password);
    }

    // Register
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Find Admin
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // Change Password
    public String changePassword(ChangePasswordRequest request) {

        Admin admin = adminRepository.findByEmail(request.getEmail());

        if (admin == null) {
            return "Admin Not Found";
        }

        if (!admin.getPassword().equals(request.getCurrentPassword())) {
            return "Current Password Incorrect";
        }

        admin.setPassword(request.getNewPassword());

        adminRepository.save(admin);

        return "Password Changed Successfully";
    }

}