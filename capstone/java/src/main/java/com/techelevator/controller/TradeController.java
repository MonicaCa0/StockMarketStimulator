package com.techelevator.controller;


import com.techelevator.model.Portfolio;
import com.techelevator.model.Trade;
import com.techelevator.services.ServiceLayer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/trade")
@RestController
public class TradeController {

    private final ServiceLayer serviceLayer;

    public TradeController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;
    }


}
