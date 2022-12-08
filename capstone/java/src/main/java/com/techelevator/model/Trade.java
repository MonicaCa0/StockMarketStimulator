package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Trade {
    private int tradeId;
    private int stockId;
    private int accountId;
    private int tradeType;

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }

    private String tradeDesc;
    BigDecimal totalCost;
    private double amountOfShares;
    //if user entered in # of shares to buy or dollars



    private int accountID;



    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }



    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
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
