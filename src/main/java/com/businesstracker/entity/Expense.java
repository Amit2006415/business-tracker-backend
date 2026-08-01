package com.businesstracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expenseName;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate expenseDate;

    private String description;

    private String billImage;

    public Expense() {
    }

    public Expense(Long id, String expenseName, Double amount,
                   LocalDate expenseDate, String description,
                   String billImage) {
        this.id = id;
        this.expenseName = expenseName;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.description = description;
        this.billImage = billImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillImage() {
        return billImage;
    }

    public void setBillImage(String billImage) {
        this.billImage = billImage;
    }
}