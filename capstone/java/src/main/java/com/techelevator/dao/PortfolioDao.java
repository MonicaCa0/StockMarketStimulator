package com.techelevator.dao;



import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;

import java.math.BigDecimal;
import java.util.List;

public interface PortfolioDao {
    List<Portfolio> getAllPortfolios(int userId);
    Portfolio getPortfolioByAccountId(int accountId);
    Portfolio createPortfolio(int userId);
    Portfolio updateBalance(Trade trade,int id);
    BigDecimal updatePortfolioBalance(int accountId, BigDecimal balance);
    void updatePortfolio(Portfolio portfolio);
    Portfolio updateBalanceForEndOfGame(BigDecimal balance, int id, int accountId);
    void deletePortfolio(int userId);

}
