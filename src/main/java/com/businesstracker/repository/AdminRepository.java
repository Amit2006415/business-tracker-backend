package com.businesstracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.businesstracker.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // ============================
    // Find By Email
    // ============================

    Admin findByEmail(String email);

    // ============================
    // Find By Mobile
    // ============================

    Admin findByMobile(String mobile);

    // ============================
    // Check Email Exists
    // ============================

    boolean existsByEmail(String email);

    // ============================
    // Check Mobile Exists
    // ============================

    boolean existsByMobile(String mobile);

    // ============================
    // Find By Email (Optional)
    // ============================

    Optional<Admin> findOptionalByEmail(String email);

}