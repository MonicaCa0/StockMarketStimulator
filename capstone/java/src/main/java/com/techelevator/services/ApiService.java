package com.techelevator.services;

import com.techelevator.model.Stock;
import com.techelevator.model.StockDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class ApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_BASE_URL =  "https://api.polygon.io/v1/open-close/";
    private final String API_KEY = "?adjusted=true&apiKey=1AWPIhaGO4hM0Rslb0l7g29hZ8Hxol2K";

    public Stock getStock(){
        Stock stock;
        stock = restTemplate.getForObject(API_BASE_URL + "AAPL/2022-12-05?adjusted=true" + API_KEY, Stock.class);
        return stock;
    }

    public Stock getStockCurrent(String info){
        Stock stock = new Stock();
        StockDTO  n ;
        LocalDate localDate = LocalDate.now().minusDays(1);
        n = restTemplate.getForObject(API_BASE_URL + info + "/" + localDate + API_KEY, StockDTO.class);
        stock.setStockName(n.getStockName());
        stock.setCurrentStockPrice(n.getCurrentStockPrice());
        stock.setStockPriceAtClose(n.getStockPriceAtClose());
        stock.setDate(n.getDate());
        return stock;
    }

    public Stock getStockCurrentByDate(String info, LocalDate date){
        Stock stock = new Stock();
        StockDTO  n ;
        n = restTemplate.getForObject(API_BASE_URL + info + "/" + date + API_KEY, StockDTO.class);
        stock.setStockName(n.getStockName());
        stock.setCurrentStockPrice(n.getCurrentStockPrice());
        stock.setStockPriceAtClose(n.getStockPriceAtClose());
        stock.setDate(n.getDate());
        return stock;
    }
}
