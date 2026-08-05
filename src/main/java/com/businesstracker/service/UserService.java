package com.businesstracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businesstracker.dto.LoginDTO;
import com.businesstracker.dto.RegisterDTO;
import com.businesstracker.entity.User;
import com.businesstracker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ============================
    // Register User
    // ============================

    public String register(RegisterDTO registerDTO) {

        // Check email already exists

        if (userRepository.existsByEmail(registerDTO.getEmail())) {

            return "Email already registered";

        }

        // Check password match

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {

            return "Password and Confirm Password do not match";

        }

        // Create User

        User user = new User();

        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPhone(registerDTO.getPhone());
        user.setPassword(registerDTO.getPassword());

        userRepository.save(user);

        return "Registration Successful";

    }

    // ============================
    // Login User
    // ============================

    public String login(LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail());

        if (user == null) {

            return "Invalid Email";

        }

        if (!user.getPassword().equals(loginDTO.getPassword())) {

            return "Invalid Password";

        }

        return "Login Successful";

    }

    // ============================
    // Find User By Email
    // ============================

    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);

    }

}