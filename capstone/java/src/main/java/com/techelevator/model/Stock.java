package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Stock {
private int stockId;
@JsonProperty("symbol")
private String stockName;
@JsonProperty("open")
private BigDecimal stockPrice;
@JsonProperty("close")
private BigDecimal stockClosePrice;
@JsonProperty("from")
private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStock_name() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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
}
