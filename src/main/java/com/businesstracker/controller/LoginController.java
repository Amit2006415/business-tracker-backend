package com.businesstracker.controller;

import com.businesstracker.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        boolean isValid = adminService.login(email, password);

        if (isValid) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}