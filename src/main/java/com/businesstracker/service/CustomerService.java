package com.businesstracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businesstracker.entity.Customer;
import com.businesstracker.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // ==========================================
    // Save Customer
    // ==========================================

    public Customer saveCustomer(Customer customer) {

        Double due = calculateDueAmount(
                customer.getTotalAmount(),
                customer.getAdvancePayment()
        );

        customer.setDueAmount(due);
        customer.setPaymentStatus(getPaymentStatus(due));

        return customerRepository.save(customer);
    }

    // ==========================================
    // Get All Customers
    // ==========================================

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // ==========================================
    // Get Customer By ID
    // ==========================================

    public Customer getCustomerById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);

        return customer.orElse(null);

    }

    // ==========================================
    // Update Customer
    // ==========================================

    public Customer updateCustomer(Customer customer) {

        Customer existingCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setWorkDate(customer.getWorkDate());
        existingCustomer.setProduct(customer.getProduct());
        existingCustomer.setTotalAmount(customer.getTotalAmount());
        existingCustomer.setAdvancePayment(customer.getAdvancePayment());
        existingCustomer.setImagePath(customer.getImagePath());

        Double due = calculateDueAmount(
                customer.getTotalAmount(),
                customer.getAdvancePayment()
        );

        existingCustomer.setDueAmount(due);
        existingCustomer.setPaymentStatus(getPaymentStatus(due));

        return customerRepository.save(existingCustomer);

    }

    // ==========================================
    // Delete Customer
    // ==========================================

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // ==========================================
    // Calculate Due Amount
    // ==========================================

    public Double calculateDueAmount(Double totalAmount, Double advancePayment) {

        return totalAmount - advancePayment;

    }

    // ==========================================
    // Payment Status
    // ==========================================

    public String getPaymentStatus(Double dueAmount) {

        return dueAmount <= 0 ? "Paid" : "Unpaid";

    }

    // ==========================================
    // Total Income
    // ==========================================

    public Double calculateTotalIncome() {

        List<Customer> customers = customerRepository.findAll();

        Double totalIncome = 0.0;

        for (Customer customer : customers) {

            totalIncome += customer.getTotalAmount();

        }

        return totalIncome;

    }

    // ==========================================
    // Total Due Amount
    // ==========================================

    public Double getTotalDueAmount() {

        List<Customer> customers = customerRepository.findAll();

        Double totalDue = 0.0;

        for (Customer customer : customers) {

            if (customer.getDueAmount() != null) {

                totalDue += customer.getDueAmount();

            }

        }

        return totalDue;

    }

}