package com.businesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businesstracker.dto.DashboardDTO;
import com.businesstracker.entity.Customer;
import com.businesstracker.entity.Expense;
import com.businesstracker.repository.CustomerRepository;
import com.businesstracker.repository.ExpenseRepository;

@Service
public class DashboardService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public DashboardDTO getDashboardData() {

        List<Customer> customers = customerRepository.findAll();
        List<Expense> expenses = expenseRepository.findAll();

        Long totalCustomers = (long) customers.size();

        Double totalIncome = 0.0;
        Double totalExpense = 0.0;
        Double totalDueAmount = 0.0;

        Long paidCustomers = 0L;
        Long unpaidCustomers = 0L;

        for (Customer customer : customers) {

            totalIncome += customer.getTotalAmount();

            if (customer.getDueAmount() != null) {
                totalDueAmount += customer.getDueAmount();
            }

            if ("Paid".equalsIgnoreCase(customer.getPaymentStatus())) {
                paidCustomers++;
            } else {
                unpaidCustomers++;
            }
        }

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }

        Double totalProfit = totalIncome - totalExpense;
        Double currentProfit = totalIncome - totalDueAmount;

        return new DashboardDTO(
            
                totalCustomers,
                totalIncome,
                totalExpense,
                totalProfit,
                paidCustomers,
                unpaidCustomers,
                totalDueAmount,
                currentProfit
        );
    }
}