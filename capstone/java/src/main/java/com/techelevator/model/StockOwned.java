package com.techelevator.model;

import java.math.BigDecimal;

public class StockOwned {
    private int stocksOwnedId;
    private int userId;
    private String stockName;
    private int accountId;
    private double totalAmountOfShares;

    public int getStocksOwnedId() {
        return stocksOwnedId;
    }

    public void setStocksOwnedId(int stocksOwnedId) {
        this.stocksOwnedId = stocksOwnedId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotalAmountOfShares() {
        return totalAmountOfShares;
    }

    public void setTotalAmountOfShares(double totalAmountOfShares) {
        this.totalAmountOfShares = totalAmountOfShares;
    }
}
