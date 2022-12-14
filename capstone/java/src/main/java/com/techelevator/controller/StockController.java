package com.techelevator.controller;

import com.techelevator.model.Stock;
import com.techelevator.model.StockOwned;
import com.techelevator.services.ApiService;
import com.techelevator.services.ServiceLayer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin
@RequestMapping(path = "/stocks")
@RestController
public class StockController {

    private final ServiceLayer serviceLayer;

    public StockController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping(path="/{date}/date",method = RequestMethod.GET)
    public List<Stock> getStock(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return serviceLayer.populateStock(date);}

    @RequestMapping(path = "/{info}" ,method = RequestMethod.GET)
    public Stock getCurrentStock(@PathVariable String info){
        return serviceLayer.getCurrentStock(info);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Stock> getAllStocks(){
        return serviceLayer.getAllStocks();
    }

    //TestPath to make sure that date parameter was not the issue, this works

    @RequestMapping(path = "/{info}/{date}", method = RequestMethod.GET)
    public Stock getStocksBDateAndName(@PathVariable String info, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date){
        return serviceLayer.getStockByDateAndName(info, date);
    }
}
