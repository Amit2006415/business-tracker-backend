package com.businesstracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ============================
    // Full Name
    // ============================

    @Column(nullable = false)
    private String fullName;

    // ============================
    // Email
    // ============================

    @Column(nullable = false, unique = true)
    private String email;

    // ============================
    // Mobile Number
    // ============================

    @Column(nullable = false, unique = true)
    private String mobile;

    // ============================
    // Password
    // ============================

    @Column(nullable = false)
    private String password;

    // ============================
    // Security Question
    // ============================

    @Column(nullable = false)
    private String securityQuestion;

    // ============================
    // Security Answer
    // ============================

    @Column(nullable = false)
    private String securityAnswer;

    public Admin() {
    }

    public Admin(Long id,
                 String fullName,
                 String email,
                 String mobile,
                 String password,
                 String securityQuestion,
                 String securityAnswer) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    // ============================
    // ID
    // ============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ============================
    // Full Name
    // ============================

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // ============================
    // Email
    // ============================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ============================
    // Mobile
    // ============================

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // ============================
    // Password
    // ============================

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ============================
    // Security Question
    // ============================

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    // ============================
    // Security Answer
    // ============================

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

}