package com.techelevator.dao;

import com.techelevator.model.StockOwned;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStockOwnedDao implements StockOwnedDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcStockOwnedDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

        @Override
    public List<StockOwned> getAllStocksByAccountId(int accountId) {
       List<StockOwned> stockOwned = new ArrayList<>();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
                " WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountId);
        while (rowSet.next()) {
           stockOwned.add(mapToStocksOwned(rowSet));
        }

        return stockOwned;
    }

    @Override
    public StockOwned getStockOwnedById(int stocksOwnedId) {
       StockOwned stockOwned = new StockOwned();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
                " WHERE stocks_owned_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, stocksOwnedId);
        if (rowSet.next()) {
            stockOwned = mapToStocksOwned(rowSet);
        }

        return stockOwned;
    }
    public StockOwned getStockOwnedByIdAndName(int accountId, String stockName) {
        StockOwned stockOwned = new StockOwned();
        String sql = "SELECT stocks_owned_id, user_id, stock_name, account_id, total_amount_of_shares FROM stocks_owned" +
                " WHERE account_id = ? AND stock_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,accountId, stockName);
        if (rowSet.next()) {
            stockOwned = mapToStocksOwned(rowSet);
        }

        return stockOwned;
    }
    @Override
    public StockOwned logStocks(Trade trade, int userId, String stockName) {
        String sql = "INSERT INTO stocks_owned (user_id, stock_name, account_id, total_amount_of_shares ) " +
                "VALUES (?,?,?,?) RETURNING stocks_owned_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, userId, stockName, trade.getAccountId(), trade.getAmountOfShares()) ;

        return getStockOwnedById(id);
    }

    @Override
    public void updateStocks(Trade trade, String stockName) {
        if(trade.getTradeTypeId() == 1 ) {
            String sql = "UPDATE stocks_owned SET total_amount_of_shares = total_amount_of_shares +  ? WHERE account_id = ? AND stock_name = ?";
            jdbcTemplate.update(sql, trade.getAmountOfShares(), trade.getAccountId(), stockName);
        } else if(trade.getTradeTypeId() == 2){
            String sql = "UPDATE stocks_owned SET total_amount_of_shares = total_amount_of_shares - ? WHERE account_id = ? AND stock_name = ?";
            jdbcTemplate.update(sql,trade.getAmountOfShares(),trade.getAccountId(), stockName);
        }
    }
        public void deleteStockOwned(int accountId, String stockName){
        String sql = "DELETE from stocks_owned WHERE account_id = ? AND stock_name = ?";
        jdbcTemplate.update(sql,accountId, stockName);
        }

    private StockOwned mapToStocksOwned(SqlRowSet result){
        StockOwned stockOwned = new StockOwned();

        stockOwned.setStocksOwnedId(result.getInt("stocks_owned_id"));
        stockOwned.setUserId(result.getInt("user_id"));
        stockOwned.setStockName(result.getString("stock_name"));
        stockOwned.setAccountId(result.getInt("account_id"));

            stockOwned.setTotalAmountOfShares(result.getDouble("total_amount_of_shares"));
        return stockOwned;

}



}
