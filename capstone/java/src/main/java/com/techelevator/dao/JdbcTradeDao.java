package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTradeDao implements TradeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTradeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createTrade(Trade trade) {
        String sql = "INSERT INTO trade(stock_id, account_id, trade_type_id, total_cost, amount_of_shares, buy_type " +
                    "VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, trade);
    }

    @Override
    public void deleteTrade(Trade trade){
        String sql = "DELETE FROM trade WHERE trade_id = ? ";
        jdbcTemplate.update(sql, trade.getTradeId());
    }

    @Override
    public List<Trade> getAllTrades(int accountID){
        List<Trade> allTrades = new ArrayList<>();
        String sql = "SELECT t.trade_id, t.stock_id, t.account_id, t.trade_type_id, t.total_cost, t.amount_of_shares, ta.trade_type_desc " +
                "FROM trade t " +
                "JOIN trade_type ON t.trade_type_id = ta.trade_type_id WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountID);
        while(rowSet.next()){
            allTrades.add(mapToTrade(rowSet));
        }
        return allTrades;
    }
    public Trade getTradeById(int tradeID){
        Trade newTrade = new Trade();
        String sql = "SELECT t.trade_id, t.stock_id, t.account_id, t.trade_type_id, t.total_cost, t.amount_of_shares, ta.trade_type_desc " +
                "FROM trade t " +
                "JOIN trade_type ON t.trade_type_id = ta.trade_type_id WHERE t.trade_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tradeID);
        if(rowSet.next()){
            newTrade = mapToTrade(rowSet);
        }
        return newTrade;
    }

    @Override
    public Trade buyStock(Trade trade){
        String sql = "INSERT INTO trade(stock_id, account_id, trade_type_id, total_cost, amount_of_shares " +
                "VALUES(?,?,?,?,?) RETURNING trade_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, trade.getStockId(), trade.getAccountID(), 1, trade.getTotalCost(), trade.getAmountOfShares());
        return getTradeById(id);
    }

    @Override
    public Trade sellStock(Trade trade){
        String sql = "INSERT INTO trade(stock_id, account_id, trade_type_id, total_cost, amount_of_shares " +
                "VALUES(?,?,?,?,?) RETURNING trade_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, trade.getStockId(), trade.getAccountID(), 2, trade.getTotalCost(), trade.getAmountOfShares());
        return getTradeById(id);
    }



    private Trade mapToTrade(SqlRowSet result){
        Trade trade = new Trade();
        trade.setTradeId(result.getInt("trade_id"));
        trade.setStockId(result.getInt("stock_id"));
        trade.setAccountID(result.getInt("account_id"));
        trade.setTradeType(result.getInt("trade_type_id"));
        trade.setTradeDesc(result.getString("trade_type_id"));
        trade.setTotalCost(result.getBigDecimal("total_cost"));
        trade.setTradeDesc(result.getString("trade_type_desc"));
        trade.setAmountOfShares(result.getDouble("amount_of_shares"));
        return trade;
    }



}
