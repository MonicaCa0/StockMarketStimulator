package com.techelevator.controller;

import com.techelevator.model.Portfolio;
import com.techelevator.services.ServiceLayer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    private final ServiceLayer serviceLayer;

    public PortfolioController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping("/{id}")
public List<Portfolio> getAllPortfolios(@PathVariable int id, Principal principal){
    return serviceLayer.getAllPortfolios(id, principal);
}
    @RequestMapping("/{id}/account/{accountId}")
    public Portfolio getAllPortfolios(@PathVariable int id, @PathVariable int accountId, Principal principal){
        return serviceLayer.getPortfolioByAccountId(id,accountId, principal);
    }

    @RequestMapping("/{id}/balance/{accountId}")
    public BigDecimal getPortfolioBalance(@PathVariable int id, @PathVariable int accountId, Principal principal){
        return serviceLayer.getPortfolioBalance(id, accountId, principal);
    }
}
