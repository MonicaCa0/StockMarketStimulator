package com.techelevator.services;


import com.techelevator.dao.GameDao;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.dao.StockDao;
import com.techelevator.dao.UserDao;

import com.techelevator.dao.*;

import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
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


   public List<Game> getAllGames(){
        return gameDao.getAllGames();
    }

   public List<Game> getAllGamesByUserId(int userId, Principal principal){
       int checkId = userDao.findIdByUsername(principal.getName());
       if(checkId == userId) {
           return gameDao.getAllGamesByOrganizer(userId);
       } else{
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }

   }

    public Game addUser(Game game, int id, Principal principal) {
        Game checkGame =gameDao.getGameByGameName(game.getGameName());
        int userIdFromGame = checkGame.getOrganizerUserId();
        int checkId = userDao.findIdByUsername(principal.getName());
        if (userIdFromGame == id && checkId == id) {
            checkGame.setPlayerUserId(game.getPlayerUserId());
            Portfolio portfolio = portfolioDao.createPortfolio(game.getPlayerUserId());
            int accountId = portfolio.getAccountId();
            return gameDao.addUser(checkGame, accountId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }

    }
    public List<Game> getAllPlayersInvited(int gameId, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameId);
        int secondCheck = game.getOrganizerUserId();
        if(checkId == secondCheck){
            return gameDao.getAllPlayersInvitedToAGame(gameId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public List<Game> getAllPlayersApproved(int gameId, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameId);
        int secondCheck = game.getOrganizerUserId();
        if(checkId == secondCheck){
            return gameDao.getAllApprovedPlayersInAGame(gameId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }
    public List<Game> getAllGamesForPlayer(int playerId, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        if(playerId == checkId){
            return gameDao.getAllGamesForPlayer(playerId);

        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }
    public List<Game> getPendingInvites(@PathVariable int playerId, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        if(checkId == playerId){
            return gameDao.getPlayersPendingInvites(playerId);

        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }



   public Game approveOrDenyRequest (int playerId, int gameId, Game game, Principal principal){
       int checkId = userDao.findIdByUsername(principal.getName());

       if(checkId == playerId ){
           Game updatedGame = gameDao.getGameByPlayer(playerId,gameId);
           updatedGame.setApprovalId(game.getApprovalId());
           return gameDao.userApproveOrDeny(updatedGame,gameId);

       }else {
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }
   }

   public List<Stock> populateStock() {
       File file = new File("src\\Stocks.txt");
       try (Scanner scanner = new Scanner(file)) {
           while (scanner.hasNextLine()) {
               String stockName = scanner.nextLine();
               Stock stock = apiService.getStockCurrent(stockName);
               stockDao.createStock(stock);
           }
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
        return getAllStocks();
   }


   public BigDecimal getPortfolioBalance (){
        //  Need to log how much of the stock they currently have
       //  Need to take that of that stock and multiply it by the currentStock price
       //  Then need to take those stocks and add up all the prices;

        List<Trade> tradesList= new ArrayList<>();
        List<Stock> listofCurrentStocks = stockDao.getAllStocks();
//        int i =0;
//       while (tradesList.size()-1 != i) {
//
//
//           i++;
//       }

       for(Trade t: tradesList){
           if(t.getTradeType() == 1){

           }
       }
// will then return that calculated balance and insert it into the portfolio

       return null;
   }

   public Stock getStockByDateAndName(LocalDate date, String info){
        return stockDao.getStockByDate(date,info);
   }



   public Stock getCurrentStock(String info) {
       LocalDate localDate = LocalDate.now().minusDays(1);
           Stock newStock = apiService.getStockCurrent(info);
          if(newStock != null){
              stockDao.createStock(newStock);
          }
        return newStock;
   }

   public List<Stock> getAllStocks(){
        return stockDao.getAllStocks();
   }

   public List<Trade> getAllTrades(int id, int gameID, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameID);
        int userId = game.getPlayerUserId();

        if(userId == id && checkId == id){
            return tradeDao.getAllTrades(game.getPlayerAccountId());
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public Trade buyStock(int id, int gameID, Principal principal, Trade trade) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameID);
        int userId = game.getPlayerUserId();

        if(userId == id && checkId == id) {
            return tradeDao.buyStock(trade);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public Trade sellStock(int id, int gameID, Principal principal, Trade trade) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameID);
        int userId = game.getPlayerUserId();
        if(userId == id && checkId == id) {
            return tradeDao.sellStock(trade);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

}

