package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;

public interface TradeDao {

    void buy(Trade trade, Portfolio portfolio);

    void sell(Trade trade, Stock stock);

    void createTrade(Trade trade);
}
