package com.businesstracker.repository;

import com.businesstracker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find Customer by Name
    Customer findByCustomerName(String customerName);

    // Find Customers by Payment Status
    List<Customer> findByPaymentStatus(String paymentStatus);

    // Find Customers Between Dates
    List<Customer> findByWorkDateBetween(LocalDate startDate, LocalDate endDate);

}