package com.techelevator.dao;

import com.techelevator.model.StocksOwned;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStocksOwned implements StocksOwnedDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcStocksOwned(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

        @Override
    public List<StocksOwned> getAllStocksByAccountId(int accountId) {
       List<StocksOwned> stocksOwned = new ArrayList<>();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_shares FROM stocks_owned" +
                " WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountId);
        while (rowSet.next()) {
           stocksOwned.add(mapToStocksOwned(rowSet));
        }

        return stocksOwned;
    }

    @Override
    public StocksOwned getStocksOwnedById(int stocksOwnedId) {
       StocksOwned stocksOwned = new StocksOwned();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_shares FROM stocks_owned" +
                " WHERE stocks_owned_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, stocksOwnedId);
        if (rowSet.next()) {
            stocksOwned = mapToStocksOwned(rowSet);
        }

        return stocksOwned;
    }

    @Override
    public StocksOwned logStocks(Trade trade, int userId, String stockName) {
        String sql = "INSERT INTO stocks_owned (user_id, stock_name, account_id, total_amount_shares ) " +
                "VALUES (?,?,?,?) RETURNING stocks_owned_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, userId, stockName, trade.getAccountId(), trade.getAmountOfShares()) ;

        return getStocksOwnedById(id);
    }

    @Override
    public void updateStocksWhenSold(Trade trade, String stockName) {
        String sql = "UPDATE stocks_owned SET total_amount_shares -= ? WHERE account_id = ? AND stock_name = ?";
      jdbcTemplate.update(sql,trade.getAmountOfShares(), stockName);
    }

    public void updateStocksWhenBought(Trade trade, String stockName) {
        String sql = "UPDATE stocks_owned SET total_amount_shares += ? WHERE account_id = ? AND stock_name = ?";
        jdbcTemplate.update(sql,trade.getAmountOfShares(), stockName);
    }




    private StocksOwned mapToStocksOwned(SqlRowSet result){
        StocksOwned stocksOwned = new StocksOwned();

        stocksOwned.setStocksOwnedId(result.getInt("stocks_owned_id"));
        stocksOwned.setUserId(result.getInt("user_id"));
        stocksOwned.setStockName(result.getString("stock_name"));
        stocksOwned.setAccountId(result.getInt("account_id"));
        if(result.getBigDecimal("total_amount_shares") != null) {
            stocksOwned.setTotalAmountOfShares(result.getBigDecimal("total_amount_shares"));
        }
        return stocksOwned;

}



}
