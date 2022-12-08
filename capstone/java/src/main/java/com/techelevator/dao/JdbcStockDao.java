package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.Stock;
import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcStockDao implements StockDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcStockDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Stock getStockInfo(int stockId) {
        Stock stock = null;
        String sql = "SELECT stock_id, stock_name, current_stock_price, stock_price_at_close, date FROM stock WHERE stock_id = ?";
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

    @Override
    public List<Stock> getAllStocksByDate(Date date) {
        LocalDate localDate = LocalDate.now().minusDays(1);
        List<Stock> stocks = new ArrayList<>();
        String sql = "SELECT stock_name, current_stock_price, stock_price_at_close, date FROM stock";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            stocks.add(mapToStock(rowSet));
        }
        return stocks;
    }

    public Stock createStock(Stock stock){
        String sql = "INSERT INTO stock (stock_name, current_stock_price, stock_price_at_close, date) " +
                "VALUES (?, ?, ?, ?) RETURNING stock_id ";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, stock.getStock_name(), stock.getStockPrice(), stock.getStockClosePrice(), stock.getDate());
        return getStockInfo(id);
    }
    private Stock mapToStock(SqlRowSet result){
        Stock stock = new Stock();
        stock.setStockId(result.getInt("stock_id"));
        stock.setStockName(result.getString("stock_name"));
        stock.setStockPrice(result.getBigDecimal("current_stock_price"));
        stock.setStockClosePrice(result.getBigDecimal("stock_price_at_close"));
        if(result.getDate("date").toLocalDate()!= null){stock.setLocalDate(result.getDate("date").toLocalDate());}
        return stock;
    }
}
