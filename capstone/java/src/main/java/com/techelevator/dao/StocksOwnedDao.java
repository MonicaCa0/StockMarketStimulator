package com.techelevator.dao;

import com.techelevator.model.StocksOwned;
import com.techelevator.model.Trade;

import java.util.List;

public interface StocksOwnedDao {

    List<StocksOwned> getAllStocksByAccountId(int accountId);
    StocksOwned getStocksOwnedById(int stocksOwnedId);
    void updateStocks(Trade trade, String stockName);
    StocksOwned logStocks(Trade trade, int userId, String stockName);
    StocksOwned getStocksOwnedByIdAndName(int accountId, String stockName);
}
