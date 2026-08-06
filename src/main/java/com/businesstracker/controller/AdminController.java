package com.businesstracker.controller;

import com.businesstracker.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private static final String ADMIN_EMAIL = "admin@businesstracker.com";
    private static final String ADMIN_PASSWORD = "admin123";

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        if (ADMIN_EMAIL.equals(request.getEmail())
                && ADMIN_PASSWORD.equals(request.getPassword())) {

            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest().body("Invalid Email or Password");
    }
}