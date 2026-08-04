package com.businesstracker.dto;

public class DashboardDTO {

    private Long totalCustomers;
    private Double totalIncome;
    private Double totalExpense;
    private Double totalProfit;
    private Double totalDueAmount;
    private Long paidCustomers;
    private Long unpaidCustomers;

    public DashboardDTO() {
    }

    public DashboardDTO(Long totalCustomers,
                        Double totalIncome,
                        Double totalExpense,
                        Double totalProfit,
                        Long paidCustomers,
                        Long unpaidCustomers,
                        Double totalDueAmount) {

        this.totalCustomers = totalCustomers;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.totalProfit = totalProfit;
        this.paidCustomers = paidCustomers;
        this.unpaidCustomers = unpaidCustomers;
        this.totalDueAmount = totalDueAmount;
    }

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Double getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(Double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    public Long getPaidCustomers() {
        return paidCustomers;
    }

    public void setPaidCustomers(Long paidCustomers) {
        this.paidCustomers = paidCustomers;
    }

    public Long getUnpaidCustomers() {
        return unpaidCustomers;
    }

    public void setUnpaidCustomers(Long unpaidCustomers) {
        this.unpaidCustomers = unpaidCustomers;
    }
}