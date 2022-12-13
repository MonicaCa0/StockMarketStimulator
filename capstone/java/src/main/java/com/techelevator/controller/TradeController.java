package com.techelevator.controller;


import com.techelevator.model.Portfolio;
import com.techelevator.model.Trade;
import com.techelevator.services.ServiceLayer;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@CrossOrigin
@RequestMapping(path = "/trades")
@RestController
public class TradeController {

    private final ServiceLayer serviceLayer;

    public TradeController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public List<Trade> getAllTradesByGameMade(@PathVariable int id, Principal principal){
//        return serviceLayer.getAllTrades(id, principal);
//    }



    @RequestMapping(path = "/{id}/allTrades/{gameID}", method = RequestMethod.GET)
    public List<Trade> getAllTradesByGame(@PathVariable int id, @PathVariable int gameID, Principal principal){
        return serviceLayer.getAllTrades(id, gameID, principal);
    }

    @RequestMapping(path = "/{id}/buy/{gameID}", method = RequestMethod.POST)
    public Trade buyStock(@PathVariable int id, @PathVariable int gameID, @RequestBody Trade trade, Principal principal){
        return serviceLayer.buyStock(id, gameID, principal, trade);
    }

    @RequestMapping(path = "/{id}/sell/{gameID}", method = RequestMethod.POST)
    public Trade sellStock(@PathVariable int id, @PathVariable int gameID, @RequestBody Trade trade, Principal principal){
        return serviceLayer.sellStock(id, gameID, principal, trade);
    }



}
