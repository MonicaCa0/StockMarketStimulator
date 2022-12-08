package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;

public interface TradeDao {

    void createTrade(Trade trade);

    void deleteTrade(Trade trade);
}
