package com.businesstracker.controller;

import com.businesstracker.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profit")
@CrossOrigin(origins = "*")
public class ProfitController {

    @Autowired
    private ProfitService profitService;

    // Get Total Profit
    @GetMapping("/total")
    public Double getProfit() {
        return profitService.calculateProfit();
    }
}