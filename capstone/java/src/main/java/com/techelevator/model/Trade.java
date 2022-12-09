package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Trade {
    private int tradeId;
    private int stockId;
    private int accountId;
    private int tradeTypeId;
    private String tradeDesc;
    BigDecimal totalCost;
    private double amountOfShares;

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }
    public int getTradeTypeId() {
        return tradeTypeId;
    }

    public void setTradeTypeId(int tradeTypeId) {
        this.tradeTypeId = tradeTypeId;
    }
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public double getAmountOfShares() {
        return amountOfShares;
    }

    public void setAmountOfShares(double amountOfShares) {
        this.amountOfShares = amountOfShares;
    }


    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
