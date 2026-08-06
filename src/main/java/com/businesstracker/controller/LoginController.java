package com.businesstracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businesstracker.dto.LoginRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    // Fixed Login Credentials
    private static final String FIXED_EMAIL = "admin@businesstracker.com";
    private static final String FIXED_PASSWORD = "admin123";

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        if (request.getEmail().equalsIgnoreCase(FIXED_EMAIL)
                && request.getPassword().equals(FIXED_PASSWORD)) {

            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest().body("Invalid Email or Password");
    }
}