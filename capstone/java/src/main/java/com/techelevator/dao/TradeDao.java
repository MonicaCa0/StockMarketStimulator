package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;

public interface TradeDao {

    void buy(Trade trade, Portfolio portfolio);

    void sell(Trade trade, Portfolio portfolio);
    //changed this from a Stock to a Portfolio

    void createTrade(Trade trade);

    void deleteTrade(Trade trade);
}
