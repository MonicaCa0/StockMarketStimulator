package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Trade {
    private int tradeId;
    private int stockId;
    private int accountId;
    private int tradeType;
    BigDecimal totalCost;
    private double amountOfShares;
<<<<<<< HEAD
    //if user entered in # of shares to buy or dollars




=======
    private int accountID;



    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
>>>>>>> 8510f72cd5b2329ac4394bed4783ba77dc83b931


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

<<<<<<< HEAD
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
=======
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return getTradeID() == trade.getTradeID() && getStockID() == trade.getStockID() && getTradeType() == trade.getTradeType() && Double.compare(trade.getAmountOfShares(), getAmountOfShares()) == 0 && Objects.equals(getTotalCost(), trade.getTotalCost()) && Objects.equals(getAccountID(), trade.getAccountID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTradeID(), getStockID(), getTradeType(), getTotalCost(), getAmountOfShares(), getAccountID());
>>>>>>> 8510f72cd5b2329ac4394bed4783ba77dc83b931
    }
}
