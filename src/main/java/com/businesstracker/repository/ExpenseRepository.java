package com.businesstracker.repository;

import com.businesstracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find Expense by Date
    List<Expense> findByExpenseDate(LocalDate expenseDate);

    // Find Expense Between Dates
    List<Expense> findByExpenseDateBetween(LocalDate startDate,
                                           LocalDate endDate);

    // Find Expense by Name
    List<Expense> findByExpenseName(String expenseName);

}