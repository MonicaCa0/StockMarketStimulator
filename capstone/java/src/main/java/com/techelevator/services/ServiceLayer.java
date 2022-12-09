package com.techelevator.services;


import com.techelevator.dao.GameDao;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.dao.StockDao;
import com.techelevator.dao.UserDao;

import com.techelevator.dao.*;

import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
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
    private StockOwnedDao stockOwnedDao;

    ServiceLayer(GameDao gameDao, UserDao userDao, PortfolioDao portfolioDao, StockDao stockDao, ApiService apiService, TradeDao tradeDao, StockOwnedDao stockOwnedDao) {
        this.gameDao = gameDao;
        this.userDao = userDao;
        this.portfolioDao = portfolioDao;
        this.stockDao = stockDao;
        this.apiService = apiService;
        this.tradeDao = tradeDao;
        this.stockOwnedDao = stockOwnedDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public int findIdByUsername(String username) {
        return userDao.findIdByUsername(username);
    }

    public Game createNewGame(Game game, Principal principal, int id) {
        int userId = userDao.findIdByUsername(principal.getName());

        if (id == userId) {
            Portfolio portfolio = portfolioDao.createPortfolio(game.getOrganizerUserId());
            game.setOrganizerUserId(userId);
            return gameDao.createGame(game, portfolio.getAccountId());

        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }

    }


    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getAllGamesByUserId(int userId, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        if (checkId == userId) {
            return gameDao.getAllGamesByOrganizer(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }

    }

    public Game addUser(Game game, int id, Principal principal) {
        Game checkGame = gameDao.getGameByGameName(game.getGameName());
        int userIdFromGame = checkGame.getOrganizerUserId();
        int checkId = userDao.findIdByUsername(principal.getName());
        boolean exists = false;
        boolean organizerId = false;
        List<Game> games = gameDao.getAllPlayersInvitedToAGame(checkGame.getGameId());
        if (userIdFromGame == id && checkId == id) {
            for (Game g : games) {
                if (g.getPlayerUserId() == game.getPlayerUserId()) {
                    exists = true;
                }
            }
            if (userIdFromGame == game.getPlayerUserId()) {
                organizerId = true;
            }
            if (organizerId) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot invite yourself.");
            }
                else if (exists) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The player has already been invited to the game.");
                } else {
                    checkGame.setPlayerUserId(game.getPlayerUserId());
                    Portfolio portfolio = portfolioDao.createPortfolio(game.getPlayerUserId());
                    int accountId = portfolio.getAccountId();
                    return gameDao.addUser(checkGame, accountId);

                }
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
            }

        }


    public List<Game> getAllPlayersInvited(int gameId, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameId);
        int secondCheck = game.getOrganizerUserId();
        if (checkId == secondCheck) {
            return gameDao.getAllPlayersInvitedToAGame(gameId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public List<Game> getAllPlayersApproved(int gameId, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameId);
        int secondCheck = game.getOrganizerUserId();
        if (checkId == secondCheck) {
            return gameDao.getAllApprovedPlayersInAGame(gameId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public List<Game> getAllGamesForPlayer(int playerId, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        if (playerId == checkId) {
            return gameDao.getAllGamesForPlayer(playerId);

        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public List<Game> getPendingInvites(@PathVariable int playerId, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        if (checkId == playerId) {
            return gameDao.getPlayersPendingInvites(playerId);

        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }


    public Game approveOrDenyRequest(int playerId, int gameId, Game game, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());

        if (checkId == playerId) {
            Game updatedGame = gameDao.getGameByPlayer(playerId, gameId);
            updatedGame.setApprovalId(game.getApprovalId());
            return gameDao.userApproveOrDeny(updatedGame, gameId);

        } else {
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

    public List<Portfolio> getAllPortfolios(int id, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        if(id == checkId){
            return portfolioDao.getAllPortfolios(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }
    public Portfolio getPortfolioByAccountId(int id,int accountId, Principal principal){
        int checkId = userDao.findIdByUsername(principal.getName());
        if(id == checkId){
            return portfolioDao.getPortfolioByAccountId(accountId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public BigDecimal getPortfolioBalance() {
        //  Need to log how much of the stock they currently have
        //  Need to take that of that stock and multiply it by the currentStock price
        //  Then need to take those stocks and add up all the prices;

        List<Trade> tradesList = new ArrayList<>();
        List<Stock> listofCurrentStocks = stockDao.getAllStocks();
//        int i =0;
//       while (tradesList.size()-1 != i) {
//
//
//           i++;
//       }

//        for (Trade t : tradesList) {
//            if (t.getTradeType() == 1) {
//
//            }
//        }
// will then return that calculated balance and insert it into the portfolio
//
        return null;
    }

    public Stock getStockByDateAndName(LocalDate date, String info) {
        return stockDao.getStockByDate(date, info);
    }


    public Stock getCurrentStock(String info) {
        LocalDate localDate = LocalDate.now().minusDays(1);
        Stock newStock = apiService.getStockCurrent(info);
        Stock stock = stockDao.getStockByDate(localDate, info);
        if (newStock != null) {
            stockDao.createStock(newStock);
        }
        return newStock;
    }

    public List<Stock> getAllStocks() {
        return stockDao.getAllStocks();
    }

    public List<Trade> getAllTrades(int id, int gameID, Principal principal) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game game = gameDao.getGameById(gameID);
        int userId = game.getPlayerUserId();

        if (userId == id && checkId == id) {
            return tradeDao.getAllTrades(game.getPlayerAccountId());
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public Trade buyStock(int id, int gameId, Principal principal, Trade trade) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game gameForPlayer = gameDao.getGameByPlayer(id, gameId);
        Game gameForOrganizer = gameDao.getGameByOrganizer(id, gameId);
        int playerId = gameForPlayer.getPlayerUserId();
        int organizerId = gameForOrganizer.getOrganizerUserId();
        if (checkId == id && id == playerId) {
            Portfolio portfolio = portfolioDao.getPortfolioByAccountId(gameForPlayer.getPlayerAccountId());
            BigDecimal currentBalance = portfolio.getCurrentBalance();
            BigDecimal tradeCost = trade.getTotalCost();
            trade.setTradeTypeId(1);
            if(gameForPlayer.getApprovalId() ==1){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must accept the invite to trade stocks");
            }
            else if ((currentBalance.compareTo(BigDecimal.valueOf(0)) <= 0) || currentBalance.compareTo(tradeCost) <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money in your account");
            } else {
                trade.setAccountId(portfolio.getAccountId());
                Stock stock = stockDao.getStockInfo(trade.getStockId());
                String stockName = stock.getStockName();
                portfolioDao.updateBalance(trade, id);
                boolean stockExists = false;
                List<StockOwned> stocks = stockOwnedDao.getAllStocksByAccountId(portfolio.getAccountId());
                for (StockOwned stockInAccount : stocks) {
                    if (stockInAccount.getStockName().equals(stockName)) {
                        stockExists = true;
                    }
                }
                if (stockExists) {
                    stockOwnedDao.updateStocks(trade, stockName);

                }else {
                    stockOwnedDao.logStocks(trade, id, stockName);
                }
                return tradeDao.sellStock(trade);
            }
        } else if (checkId == id && id == organizerId) {
            Portfolio portfolio = portfolioDao.getPortfolioByAccountId(gameForOrganizer.getOrganizerAccountId());
            BigDecimal currentBalance = portfolio.getCurrentBalance();
            BigDecimal tradeCost = trade.getTotalCost();
            trade.setTradeTypeId(1);
          if ((currentBalance.compareTo(BigDecimal.valueOf(0)) <= 0) || currentBalance.compareTo(tradeCost) <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money in your account");
            } else {
                trade.setAccountId(portfolio.getAccountId());

                Stock stock = stockDao.getStockInfo(trade.getStockId());
                String stockName = stock.getStockName();
                portfolioDao.updateBalance(trade, id);
              boolean stockExists = false;
              List<StockOwned> stocks = stockOwnedDao.getAllStocksByAccountId(portfolio.getAccountId());
                  for (StockOwned stockInAccount : stocks) {
                      if (stockInAccount.getStockName().equals(stockName)) {
                          stockExists = true;
                      }
                  }
              if (stockExists) {
                stockOwnedDao.updateStocks(trade, stockName);

              }else {
                  stockOwnedDao.logStocks(trade, id, stockName);
              }
              return tradeDao.buyStock(trade);
          }
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }

    public Trade sellStock(int id, int gameId, Principal principal, Trade trade) {
        int checkId = userDao.findIdByUsername(principal.getName());
        Game gameForPlayer = gameDao.getGameByPlayer(id, gameId);
        Game gameForOrganizer = gameDao.getGameByOrganizer(id, gameId);
        int playerId = gameForPlayer.getPlayerUserId();
        int organizerId = gameForOrganizer.getOrganizerUserId();
        if (checkId == id && id == playerId) {
            Portfolio portfolio = portfolioDao.getPortfolioByAccountId(gameForPlayer.getPlayerAccountId());
            BigDecimal currentBalance = portfolio.getCurrentBalance();
            BigDecimal tradeCost = trade.getTotalCost();
            trade.setTradeTypeId(2);
            if(gameForPlayer.getApprovalId() ==1){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must accept the invite to trade stocks");
            }
            else if ((currentBalance.compareTo(BigDecimal.valueOf(0)) <= 0) || currentBalance.compareTo(tradeCost) <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money in your account");
            } else {
                trade.setAccountId(portfolio.getAccountId());
                Stock stock = stockDao.getStockInfo(trade.getStockId());
                String stockName = stock.getStockName();
                portfolioDao.updateBalance(trade, id);
                boolean stockExists = false;
                List<StockOwned> stocks = stockOwnedDao.getAllStocksByAccountId(portfolio.getAccountId());
                for (StockOwned stockInAccount : stocks) {
                    if (stockInAccount.getStockName().equals(stockName)) {
                        stockExists = true;
                    }
                }
                if (!stockExists) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot sell a stock you do not own");

                }else {
                    stockOwnedDao.updateStocks(trade, stockName);
                }
                return tradeDao.sellStock(trade);
            }
        } else if (checkId == id && id == organizerId) {
            Portfolio portfolio = portfolioDao.getPortfolioByAccountId(gameForOrganizer.getOrganizerAccountId());
            BigDecimal currentBalance = portfolio.getCurrentBalance();
            BigDecimal tradeCost = trade.getTotalCost();
            trade.setTradeTypeId(2);
            if ((currentBalance.compareTo(BigDecimal.valueOf(0)) <= 0) || currentBalance.compareTo(tradeCost) <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough money in your account");
            } else {
                trade.setAccountId(portfolio.getAccountId());

                Stock stock = stockDao.getStockInfo(trade.getStockId());
                String stockName = stock.getStockName();
                portfolioDao.updateBalance(trade, id);
                boolean stockExists = false;
                List<StockOwned> stocks = stockOwnedDao.getAllStocksByAccountId(portfolio.getAccountId());
                for (StockOwned stockInAccount : stocks) {
                    if (stockInAccount.getStockName().equals(stockName)) {
                        stockExists = true;
                    }
                }
                if (!stockExists) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot sell a stock you do not own");

                }else {
                    stockOwnedDao.updateStocks(trade, stockName);
                }
                return tradeDao.sellStock(trade);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
        }
    }
}

