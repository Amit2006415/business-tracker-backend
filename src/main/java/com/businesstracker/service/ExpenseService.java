package com.businesstracker.service;

import com.businesstracker.entity.Expense;
import com.businesstracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Save Expense
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Get All Expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get Expense By ID
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.orElse(null);
    }

    // Update Expense
    public Expense updateExpense(Expense expense) {

        Expense existingExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException("Expense Not Found"));

        existingExpense.setExpenseName(expense.getExpenseName());
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        existingExpense.setBillImage(expense.getBillImage());

        return expenseRepository.save(existingExpense);
    }

    // Delete Expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Calculate Total Expense
    public Double calculateTotalExpense() {

        List<Expense> expenses = expenseRepository.findAll();

        Double totalExpense = 0.0;

        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }

        return totalExpense;
    }
}