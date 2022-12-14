package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Portfolio {
    private int accountId;
    private int userId;
    private BigDecimal currentBalance;
    private BigDecimal portfolioBalance;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getPortfolioBalance() {
        return portfolioBalance;
    }

    public void setPortfolioBalance(BigDecimal portfolioBalance) {
        this.portfolioBalance = portfolioBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portfolio)) return false;
        Portfolio portfolio = (Portfolio) o;
        return accountId == portfolio.accountId && userId == portfolio.userId && currentBalance.equals(portfolio.currentBalance) && portfolioBalance.equals(portfolio.portfolioBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, currentBalance, portfolioBalance);
    }
}
