package com.businesstracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ============================
    // Logged-in User
    // ============================

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDate workDate;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private Double totalAmount;

    private Double advancePayment;

    private Double dueAmount;

    private String paymentStatus;

    private String imagePath;

    public Customer() {
    }

    public Customer(Long id,
                    User user,
                    String customerName,
                    LocalDate workDate,
                    String product,
                    Double totalAmount,
                    Double advancePayment,
                    Double dueAmount,
                    String paymentStatus,
                    String imagePath) {

        this.id = id;
        this.user = user;
        this.customerName = customerName;
        this.workDate = workDate;
        this.product = product;
        this.totalAmount = totalAmount;
        this.advancePayment = advancePayment;
        this.dueAmount = dueAmount;
        this.paymentStatus = paymentStatus;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ============================
    // User
    // ============================

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ============================
    // Customer Name
    // ============================

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // ============================
    // Work Date
    // ============================

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    // ============================
    // Product
    // ============================

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    // ============================
    // Total Amount
    // ============================

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // ============================
    // Advance Payment
    // ============================

    public Double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(Double advancePayment) {
        this.advancePayment = advancePayment;
    }

    // ============================
    // Due Amount
    // ============================

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    // ============================
    // Payment Status
    // ============================

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // ============================
    // Image
    // ============================

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}