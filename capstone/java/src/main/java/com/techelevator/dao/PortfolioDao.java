package com.techelevator.dao;



import com.techelevator.model.Portfolio;

import java.util.List;

public interface PortfolioDao {
    List<Portfolio> getAllPortfolios(int userId);
    Portfolio getPortfolioByAccountId(int accountId);
    Portfolio createPortfolio(int userId);
    void updatePortfolio(Portfolio portfolio);
    void deletePortfolio(int userId);



}
