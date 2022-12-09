package com.techelevator.model;

import java.math.BigDecimal;

public class StocksOwned {
    private int stocksOwnedId;
    private int userId;
    private String stockName;
    private int accountId;
    private BigDecimal totalAmountOfShares;

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

    public BigDecimal getTotalAmountOfShares() {
        return totalAmountOfShares;
    }

    public void setTotalAmountOfShares(BigDecimal totalAmountOfShares) {
        this.totalAmountOfShares = totalAmountOfShares;
    }
}
