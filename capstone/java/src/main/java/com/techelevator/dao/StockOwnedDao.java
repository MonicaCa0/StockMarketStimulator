package com.techelevator.dao;

import com.techelevator.model.StockOwned;
import com.techelevator.model.Trade;

import java.util.List;

public interface StockOwnedDao {

    List<StockOwned> getAllStocksByAccountId(int accountId);
    StockOwned getStockOwnedById(int stocksOwnedId);
    void updateStocks(Trade trade, String stockName);
    StockOwned logStocks(Trade trade, int userId, String stockName);
    StockOwned getStockOwnedByIdAndName(int accountId, String stockName);
    void deleteStockOwned(int accountId, String StockName);
}
