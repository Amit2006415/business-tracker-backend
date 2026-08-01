package com.businesstracker.controller;

import com.businesstracker.dto.DashboardDTO;
import com.businesstracker.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    // Dashboard Summary API
    @GetMapping
    public DashboardDTO getDashboardData() {
        return dashboardService.getDashboardData();
    }
}