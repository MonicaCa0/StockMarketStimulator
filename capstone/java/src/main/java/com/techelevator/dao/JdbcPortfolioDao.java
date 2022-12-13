package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPortfolioDao implements PortfolioDao{
private JdbcTemplate jdbcTemplate;

public JdbcPortfolioDao(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
}

    @Override
    public List<Portfolio> getAllPortfolios(int userId) {
        List<Portfolio> portfolios = new ArrayList<>();
        String sql = "SELECT account_id, user_id, current_balance, portfolio_balance FROM portfolio WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            portfolios.add(mapToPortfolio(rowSet));
        }

        return portfolios;
    }

    public List<Portfolio> getAllPortfoliosByGame(int gameId) {
        List<Portfolio> portfolios = new ArrayList<>();
        String sql = "SELECT p.account_id, p.user_id, p.current_balance, p.portfolio_balance FROM portfolio p " +
                "JOIN game_history gh ON gh.account_id = p.account_id " +
                "JOIN game g ON g.organizer_account_id = p.account_id "+
                "WHERE gh.game_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameId);


        while(rowSet.next()){
            portfolios.add(mapToPortfolio(rowSet));
        }

        return portfolios;
    }

    @Override
    public Portfolio getPortfolioByAccountId(int accountId) {
        Portfolio portfolio = null;
        String sql = "SELECT account_id, user_id, current_balance, portfolio_balance FROM portfolio WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountId);
        if(rowSet.next()){
            portfolio = mapToPortfolio(rowSet);
        }
        return portfolio;
    }

    @Override
    public Portfolio createPortfolio(int userId) {
        String sql = "INSERT INTO portfolio (user_id, current_balance, portfolio_balance) "+
                    " VALUES(?, ?, ?) RETURNING account_id";

        BigDecimal startingBalance = BigDecimal.valueOf(100000.00);
        BigDecimal portfolioBalance = BigDecimal.valueOf(0.00);;
        Integer accountId = jdbcTemplate.queryForObject(sql, Integer.class, userId, startingBalance, portfolioBalance);

        return getPortfolioByAccountId(accountId);
    }

    @Override
    public Portfolio updateBalance(Trade trade, int id) {
    if(trade.getTradeTypeId() == 1) {
        String sql = "UPDATE portfolio SET current_balance  = current_balance - ?, user_id = ? WHERE account_id = ? ";
        jdbcTemplate.update(sql, trade.getTotalCost(), id, trade.getAccountId());

    }else if (trade.getTradeTypeId() == 2){
        String sql = "UPDATE portfolio SET current_balance = current_balance + ?, user_id = ? WHERE account_id = ? ";
        jdbcTemplate.update(sql, trade.getTotalCost(), id, trade.getAccountId());

    }
        return getPortfolioByAccountId(trade.getAccountId());
    }

    @Override
    public Portfolio updateBalanceForEndOfGame(BigDecimal balance, int id, int accountId) {
            String sql = "UPDATE portfolio SET current_balance = current_balance + ?, user_id = ? WHERE account_id = ? ";
            jdbcTemplate.update(sql, balance, id, accountId);

        return getPortfolioByAccountId(accountId);
    }

    @Override
    public BigDecimal updatePortfolioBalance(int accountId, BigDecimal balance) {
            String sql = "UPDATE portfolio SET portfolio_balance = ? WHERE account_id = ? ";
            jdbcTemplate.update(sql,balance, accountId);

        return balance;
    }


    @Override
    public void updatePortfolio(Portfolio portfolio) {
    String sql = "UPDATE portfolio SET account_id = ?, user_id = ? current_balance = ?, portfolio_balance = ? WHERE user_id = ?";

    jdbcTemplate.update(sql, portfolio.getAccountId(),portfolio.getUserId(), portfolio.getCurrentBalance(),portfolio.getPortfolioBalance(), portfolio.getUserId());
    }

    @Override
    public void deletePortfolio(int userId) {
        String sql = "DELETE portfolio WHERE user_id = ?";
        jdbcTemplate.update(sql);
    }

    private Portfolio mapToPortfolio(SqlRowSet result){
        Portfolio portfolio = new Portfolio();
        portfolio.setAccountId(result.getInt("account_id"));
        portfolio.setUserId(result.getInt("user_id"));
        portfolio.setCurrentBalance(result.getBigDecimal("current_balance"));
        portfolio.setPortfolioBalance(result.getBigDecimal("portfolio_balance"));
        return portfolio;
    }

}
