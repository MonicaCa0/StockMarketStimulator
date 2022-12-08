package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTradeDao implements TradeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTradeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void buy(Trade trade, Portfolio portfolio) {

    }

    @Override
    public void sell(Trade trade, Stock stock) {

    }

    @Override
    public void createTrade(Trade trade) {
        String sql = "INSERT INTO trade(stock_id, account_id, trade_type_id, total_cost, amount_of_shares, buy_type " +
                    "VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, trade);

    }

//    private Trade mapToTrade(SqlRowSet result){
//        Trade trade = new Trade();
//        trade.setTradeID(result.getInt("trade_id"));
//        trade.setStockID(result.getInt("stock_id"));
//        trade.setTradeType(result.getInt("trade_type_id"));
//        trade.setTotalCost(result.getBigDecimal("total_cost"));
//        trade.setAmountOfShares(result.getDouble("amount_of_shares"));
//        trade.setBuyType(result.getString("buy_type"));
//        return trade;
//    }



}
