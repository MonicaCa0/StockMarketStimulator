package com.techelevator.services;

import com.techelevator.dao.GameDao;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Game;
import com.techelevator.model.Portfolio;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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

    public void addUser(Game game, int id, Principal principal){
        
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
           return gameDao.getAllGamesById(userId);
       } else{
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }

   }



}
