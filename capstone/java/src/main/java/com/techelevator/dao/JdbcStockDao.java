package com.techelevator.dao;

import com.techelevator.model.Stock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcStockDao implements StockDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcStockDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stock getStockInfo(int stockId) {
        Stock stock = null;
        String sql = "SELECT stock_name, current_stock_price, stock_price_at_close, date FROM stock WHERE stock_id = ?";
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, stockId);
        if(rowset.next()){
            stock = mapToStock(rowset);
        }
        return stock;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        String sql = "SELECT stock_name, current_stock_price, stock_price_at_close, date FROM stock";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            stocks.add(mapToStock(rowSet));
        }

        return stocks;
    }

    private Stock mapToStock(SqlRowSet result){
        Stock stock = new Stock();
        stock.setStock_name(result.getString("stock_name"));
        stock.setStockPrice(result.getBigDecimal("current_stock_price"));
        stock.setStockClosePrice(result.getBigDecimal("stock_price_at_close"));
        if(result.getDate("date").toLocalDate()!= null){stock.setDate(result.getDate("date").toLocalDate());}
        return stock;
    }

}
