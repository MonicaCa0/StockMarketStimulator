package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Stock {
    private int stockId;
    private String stock_name;
    private BigDecimal stockPrice;
    private BigDecimal stockClosePrice;
    private LocalDate date;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public BigDecimal getStockClosePrice() {
        return stockClosePrice;
    }

    public void setStockClosePrice(BigDecimal stockClosePrice) {
        this.stockClosePrice = stockClosePrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
