package com.techelevator.model;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Stock {
    private int stockId;
    private String stockName;
    private BigDecimal currentStockPrice;
    private BigDecimal stockPriceAtClose;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockId == stock.stockId && stockName.equals(stock.stockName) && currentStockPrice.equals(stock.currentStockPrice) && stockPriceAtClose.equals(stock.stockPriceAtClose) && date.equals(stock.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, stockName, currentStockPrice, stockPriceAtClose, date);
    }
}

