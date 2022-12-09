package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;

import java.util.List;

public interface TradeDao {

    void deleteTrade(Trade trade);

    List<Trade> getAllTrades(int accountID);

    public Trade buyStock(Trade trade);

    public Trade sellStock(Trade trade);
}
