package com.businesstracker.controller;

import com.businesstracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
@CrossOrigin(origins = "*")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    // Get Total Income
    @GetMapping("/total")
    public Double getTotalIncome() {
        return incomeService.calculateTotalIncome();
    }

}