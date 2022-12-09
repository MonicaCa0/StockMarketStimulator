package com.techelevator.dao;

import com.techelevator.model.StocksOwned;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStocksOwnedDao implements StocksOwnedDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcStocksOwnedDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

        @Override
    public List<StocksOwned> getAllStocksByAccountId(int accountId) {
       List<StocksOwned> stocksOwned = new ArrayList<>();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
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
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
                " WHERE stocks_owned_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, stocksOwnedId);
        if (rowSet.next()) {
            stocksOwned = mapToStocksOwned(rowSet);
        }

        return stocksOwned;
    }
    public StocksOwned getStocksOwnedByIdAndName(int accountId, String stockName) {
        StocksOwned stocksOwned = new StocksOwned();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
                " WHERE account_id = ? AND stock_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,accountId, stockName);
        if (rowSet.next()) {
            stocksOwned = mapToStocksOwned(rowSet);
        }

        return stocksOwned;
    }
    @Override
    public StocksOwned logStocks(Trade trade, int userId, String stockName) {
        String sql = "INSERT INTO stocks_owned (user_id, stock_name, account_id, total_amount_of_shares ) " +
                "VALUES (?,?,?,?) RETURNING stocks_owned_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, userId, stockName, trade.getAccountId(), trade.getAmountOfShares()) ;

        return getStocksOwnedById(id);
    }

    @Override
    public void updateStocks(Trade trade, String stockName) {
        if(trade.getTradeTypeId() ==1 ) {
            String sql = "UPDATE stocks_owned SET total_amount_of_shares = total_amount_of_shares - ? WHERE account_id = ? AND stock_name = ?";
            jdbcTemplate.update(sql, trade.getAmountOfShares(), stockName);
        } else if(trade.getTradeTypeId() ==2){
            String sql = "UPDATE stocks_owned SET total_amount_of_shares = total_amount_of_shares + ? WHERE account_id = ? AND stock_name = ?";
            jdbcTemplate.update(sql,trade.getAmountOfShares(), stockName);
        }
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
