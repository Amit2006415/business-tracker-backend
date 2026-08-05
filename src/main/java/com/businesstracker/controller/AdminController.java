package com.businesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.businesstracker.dto.ChangePasswordRequest;
import com.businesstracker.entity.Admin;
import com.businesstracker.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ==========================================
    // Register
    // ==========================================

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {

        return adminService.saveAdmin(admin);

    }

    // ==========================================
    // Login
    // ==========================================

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {

        boolean success = adminService.login(
                admin.getEmail(),
                admin.getPassword()
        );

        if (success) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }

    // ==========================================
    // Get Admin Details
    // ==========================================

    @GetMapping("/{email}")
    public Admin getAdmin(@PathVariable String email) {

        return adminService.findByEmail(email);

    }

    // ==========================================
    // Get Security Question
    // ==========================================

    @GetMapping("/security-question/{email}")
    public String getSecurityQuestion(@PathVariable String email) {

        Admin admin = adminService.findByEmail(email);

        if (admin == null) {
            return "Email Not Found";
        }

        return admin.getSecurityQuestion();

    }

    // ==========================================
    // Verify Security Answer
    // ==========================================

    @PostMapping("/verify-answer")
    public String verifyAnswer(
            @RequestParam String email,
            @RequestParam String answer) {

        boolean verified =
                adminService.verifySecurityAnswer(email, answer);

        if (verified) {
            return "Verified";
        }

        return "Invalid Answer";

    }

    // ==========================================
    // Change Password
    // ==========================================

    @PutMapping("/change-password")
    public String changePassword(
            @RequestBody ChangePasswordRequest request) {

        return adminService.changePassword(request);

    }

}