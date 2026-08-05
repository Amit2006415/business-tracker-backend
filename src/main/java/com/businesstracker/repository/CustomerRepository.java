package com.businesstracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.businesstracker.entity.Customer;
import com.businesstracker.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Get all customers of a specific user
    List<Customer> findByUser(User user);

    // Get customers by payment status of a specific user
    List<Customer> findByUserAndPaymentStatus(User user, String paymentStatus);

}