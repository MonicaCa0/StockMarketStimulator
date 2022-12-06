package com.techelevator.controller;

import com.techelevator.model.Stock;
import com.techelevator.services.ApiService;
import com.techelevator.services.ServiceLayer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/stocks")
@RestController
public class StockController {

    private final ServiceLayer serviceLayer;

    public StockController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }


    @RequestMapping(method = RequestMethod.GET)
    public void getStock(){serviceLayer.populateStock();}
/*
    @RequestMapping(path = "/{info}" ,method = RequestMethod.GET)
    public Stock getCurrentStock(@PathVariable String info){return apiService.getStockCurrent(info);}
*/
}
