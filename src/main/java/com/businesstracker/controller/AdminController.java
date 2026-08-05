package com.businesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@RequestBody Admin admin) {

        try {

            Admin savedAdmin = adminService.saveAdmin(admin);

            return ResponseEntity.ok(savedAdmin);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    // ==========================================
    // Login
    // ==========================================

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {

        boolean success = adminService.login(
                admin.getEmail(),
                admin.getPassword());

        if (success) {
            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest()
                .body("Invalid Email or Password");

    }

    // ==========================================
    // Get Admin Details
    // ==========================================

    @GetMapping("/{email}")
    public ResponseEntity<?> getAdmin(@PathVariable String email) {

        Admin admin = adminService.findByEmail(email);

        if (admin == null) {
            return ResponseEntity.badRequest()
                    .body("Email Not Found");
        }

        return ResponseEntity.ok(admin);

    }

    // ==========================================
    // Get Security Question
    // ==========================================

    @GetMapping("/security-question/{email}")
    public ResponseEntity<String> getSecurityQuestion(
            @PathVariable String email) {

        Admin admin = adminService.findByEmail(email);

        if (admin == null) {
            return ResponseEntity.badRequest()
                    .body("Email Not Found");
        }

        return ResponseEntity.ok(admin.getSecurityQuestion());

    }

    // ==========================================
    // Verify Security Answer
    // ==========================================

    @PostMapping("/verify-answer")
    public ResponseEntity<String> verifyAnswer(
            @RequestParam String email,
            @RequestParam String answer) {

        boolean verified =
                adminService.verifySecurityAnswer(email, answer);

        if (verified) {
            return ResponseEntity.ok("Verified");
        }

        return ResponseEntity.badRequest()
                .body("Invalid Answer");

    }

    // ==========================================
    // Change Password
    // ==========================================

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @RequestBody ChangePasswordRequest request) {

        String message = adminService.changePassword(request);

        return ResponseEntity.ok(message);

    }

}