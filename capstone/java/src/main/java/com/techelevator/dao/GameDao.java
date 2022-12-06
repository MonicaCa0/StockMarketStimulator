package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAllGames();
    List<Game> getAllGamesById(int userId);
    Game getGameById(int gameId);
    Game createGame(Game game, int accountId);
    Game updateGame(Game game);
    void addUser(Game game, int accountId);
    void deleteUser(int userId);
    void deleteGame(int accountId); // Organizer's account ID


}
