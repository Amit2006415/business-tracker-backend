package com.businesstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businesstracker.dto.LoginDTO;
import com.businesstracker.dto.RegisterDTO;
import com.businesstracker.entity.User;
import com.businesstracker.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // ==========================
    // Register User
    // ==========================

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO registerDTO) {

        return userService.register(registerDTO);

    }

    // ==========================
    // Login User
    // ==========================

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {

        return userService.login(loginDTO);

    }

    // ==========================
    // Get User By Email
    // ==========================

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {

        return userService.getUserByEmail(email);

    }

}