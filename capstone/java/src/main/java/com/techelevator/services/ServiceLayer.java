package com.techelevator.services;

import com.techelevator.dao.GameDao;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Game;
import com.techelevator.model.Portfolio;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {
    private GameDao gameDao;
    private UserDao userDao;
    private PortfolioDao portfolioDao;

    ServiceLayer(GameDao gameDao, UserDao userDao, PortfolioDao portfolioDao){
        this.gameDao =gameDao;
        this.userDao = userDao;
        this.portfolioDao = portfolioDao;
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

   public Game createNewGame(Game game){
       Portfolio portfolio = portfolioDao.createPortfolio(game.getOrganizerUserId());
       return gameDao.createGame(game, portfolio.getAccountId());

   }

   public List<Game> getAllGames(){
        return gameDao.getAllGames();
   }

   public List<Game> getAllGamesByUserId(int userId){
        return gameDao.getAllGamesById(userId);
   }



}
