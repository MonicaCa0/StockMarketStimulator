package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Trade {
    private int tradeID;
    private int stockID;
    private int tradeType;
    BigDecimal totalCost;
    private double amountOfShares;
    //if user entered in # of shares to buy or dollars
    private String buyType;



    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return getTradeID() == trade.getTradeID() && getStockID() == trade.getStockID() && getTradeType() == trade.getTradeType() && Double.compare(trade.getAmountOfShares(), getAmountOfShares()) == 0 && Objects.equals(getTotalCost(), trade.getTotalCost()) && Objects.equals(getBuyType(), trade.getBuyType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTradeID(), getStockID(), getTradeType(), getTotalCost(), getAmountOfShares(), getBuyType());
    }
}
