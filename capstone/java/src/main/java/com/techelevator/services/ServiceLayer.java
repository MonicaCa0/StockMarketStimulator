package com.techelevator.services;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ServiceLayer {
    private GameDao gameDao;
    private UserDao userDao;
    private PortfolioDao portfolioDao;
    private StockDao stockDao;
    private ApiService apiService;
    private TradeDao tradeDao;

    ServiceLayer(GameDao gameDao, UserDao userDao, PortfolioDao portfolioDao, StockDao stockDao, ApiService apiService, TradeDao tradeDao){
        this.gameDao =gameDao;
        this.userDao = userDao;
        this.portfolioDao = portfolioDao;
        this.stockDao = stockDao;
        this.apiService = apiService;
        this.tradeDao =tradeDao;
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }
    public User getUserById(int userId){
        return userDao.getUserById(userId);
    }
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
    public int findIdByUsername(String username){
        return userDao.findIdByUsername(username);
    }

   public Game createNewGame(Game game, Principal principal, int id){
       int userId = userDao.findIdByUsername(principal.getName());

       if(id == userId) {
           Portfolio portfolio = portfolioDao.createPortfolio(game.getOrganizerUserId());
           game.setOrganizerUserId(userId);
           return gameDao.createGame(game, portfolio.getAccountId());

       } else {
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }

   }


    public void addUser(int id, Game game, Principal principal){
        int user = userDao.findIdByUsername(principal.getName());
    }

   public List<Game> getAllGames(){
        return gameDao.getAllGames();
   }

   public List<Game> getAllGamesByUserId(int userId, Principal principal){
       int checkId = userDao.findIdByUsername(principal.getName());
       if(checkId == userId) {
           return gameDao.getAllGamesById(userId);
       } else{
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }

   }
   public void populateStock(){
        List<String> stockInfo = new ArrayList<>();
       File file = new File("src\\Stocks.txt");
       try(Scanner scanner = new Scanner(file)){
           while(scanner.hasNextLine()){
               String stockName = scanner.nextLine();
               Stock stock = apiService.getStockCurrent(stockName);
               stockDao.createStock(stock);
           }
       }catch(Exception e){
           e.getMessage();
       }

   }

   //Greg Additions Below
   public void buy(Trade trade, Portfolio portfolio ){
        tradeDao.buy(trade, portfolio);
   }

   public void sell(Trade trade, Portfolio portfolio){
        tradeDao.sell(trade, portfolio);
   }
  //Greg Additions above

}
