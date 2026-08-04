package com.businesstracker.controller;

import com.businesstracker.entity.Customer;
import com.businesstracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // ==========================================
    // Add Customer
    // ==========================================

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // ==========================================
    // Get All Customers
    // ==========================================

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // ==========================================
    // Get Total Due Amount
    // ==========================================

    @GetMapping("/due/total")
    public Double getTotalDueAmount() {
        return customerService.getTotalDueAmount();
    }

    // ==========================================
    // Get Customer By ID
    // ==========================================

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // ==========================================
    // Update Customer
    // ==========================================

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer) {

        customer.setId(id);
        return customerService.updateCustomer(customer);
    }

    // ==========================================
    // Delete Customer
    // ==========================================

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);
        return "Customer Deleted Successfully";
    }

}