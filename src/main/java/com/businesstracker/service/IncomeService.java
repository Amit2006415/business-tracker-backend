package com.businesstracker.service;

import com.businesstracker.entity.Customer;
import com.businesstracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private CustomerRepository customerRepository;

    // Calculate Total Income
    public Double calculateTotalIncome() {

        List<Customer> customers = customerRepository.findAll();

        Double totalIncome = 0.0;

        for (Customer customer : customers) {
            totalIncome += customer.getTotalAmount();
        }

        return totalIncome;
    }

}