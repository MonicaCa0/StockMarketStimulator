package com.techelevator.dao;

import com.techelevator.model.Stock;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StockDao {
    Stock getStockInfo(int stockId);
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    public List<Stock> getAllStocksByDate(LocalDate date);
    public Stock getStockByDateAndName(LocalDate date, String info);
}
