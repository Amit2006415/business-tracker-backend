package com.businesstracker.controller;

import com.businesstracker.entity.Expense;
import com.businesstracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Add Expense
    @PostMapping
    public Expense saveExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    // Get All Expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Get Expense By ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // Update Expense
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense expense) {

        expense.setId(id);
        return expenseService.updateExpense(expense);
    }

    // Delete Expense
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);
        return "Expense Deleted Successfully";
    }

    // Get Total Expense
    @GetMapping("/total")
    public Double getTotalExpense() {
        return expenseService.calculateTotalExpense();
    }

}