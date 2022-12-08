package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class StockDTO {

    private int stockId;
    @JsonProperty("symbol")
    private String stockName;
    @JsonProperty("open")
    private BigDecimal currentStockPrice;
    @JsonProperty("close")
    private BigDecimal stockPriceAtClose;
    @JsonProperty("from")
    private LocalDate date;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getCurrentStockPrice() {
        return currentStockPrice;
    }

    public void setCurrentStockPrice(BigDecimal currentStockPrice) {
        this.currentStockPrice = currentStockPrice;
    }

    public BigDecimal getStockPriceAtClose() {
        return stockPriceAtClose;
    }

    public void setStockPriceAtClose(BigDecimal stockPriceAtClose) {
        this.stockPriceAtClose = stockPriceAtClose;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}