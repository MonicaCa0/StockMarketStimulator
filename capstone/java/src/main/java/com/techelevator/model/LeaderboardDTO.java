package com.techelevator.model;

import java.math.BigDecimal;

public class LeaderboardDTO {
    private BigDecimal portfolioBalance;
    private String username;

    public BigDecimal getPortfolioBalance() {
        return portfolioBalance;
    }

    public void setPortfolioBalance(BigDecimal portfolioBalance) {
        this.portfolioBalance = portfolioBalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
