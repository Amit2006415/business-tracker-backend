package com.businesstracker.service;

import com.businesstracker.entity.Customer;
import com.businesstracker.entity.Expense;
import com.businesstracker.repository.CustomerRepository;
import com.businesstracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    // Calculate Profit = Total Income - Total Expense
    public Double calculateProfit() {

        List<Customer> customers = customerRepository.findAll();

        Double totalIncome = 0.0;

        for (Customer customer : customers) {
            totalIncome += customer.getTotalAmount();
        }

        List<Expense> expenses = expenseRepository.findAll();

        Double totalExpense = 0.0;

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }

        return totalIncome - totalExpense;
    }
}