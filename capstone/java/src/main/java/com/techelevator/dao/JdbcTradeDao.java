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
        String sql = "SELECT trade_id, stock_id, account_id, trade_type_id, total_cost, amount_of_shares " +
                "FROM trade WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountID, Trade.class);
        while(rowSet.next()){
            allTrades.add(mapToTrade(rowSet));
        }
        return allTrades;
    }

    @Override
    public Trade buyStock(Trade trade){
        String sql = "INSERT INTO trade(stock_id, account_id, trade_type_id, total_cost, amount_of_shares " +
                "VALUES(?,?,?,?,?)";
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

    //make the trade
    public Trade getTradeById(int tradeID){
        Trade newTrade = new Trade();
        String sql = "SELECT trade_id, stock_id, account_id, trade_type_id, total_cost, amount_of_shares " +
                "FROM trade WHERE trade_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tradeID);
        if(rowSet.next()){
            newTrade = mapToTrade(rowSet);
        }
        return newTrade;
    }

    private Trade mapToTrade(SqlRowSet result){
        Trade trade = new Trade();
        trade.setTradeId(result.getInt("trade_id"));
        trade.setStockId(result.getInt("stock_id"));
        trade.setAccountID(result.getInt("account_id"));
        trade.setTradeType(result.getInt("trade_type_id"));
        trade.setTotalCost(result.getBigDecimal("total_cost"));
        trade.setAmountOfShares(result.getDouble("amount_of_shares"));
        return trade;
    }



}
