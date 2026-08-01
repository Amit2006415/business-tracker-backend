package com.businesstracker.controller;

import com.businesstracker.dto.ChangePasswordRequest;
import com.businesstracker.entity.Admin;
import com.businesstracker.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {

        return adminService.saveAdmin(admin);

    }

    // Login

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

    // Get Admin

    @GetMapping("/{email}")
    public Admin getAdmin(@PathVariable String email) {

        return adminService.findByEmail(email);

    }

    // Change Password

    @PutMapping("/change-password")
    public String changePassword(
            @RequestBody ChangePasswordRequest request) {

        return adminService.changePassword(request);

    }

}