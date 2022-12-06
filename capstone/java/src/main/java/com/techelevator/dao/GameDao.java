package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAllGames(int userId);
    Game getGameById(int gameId);
    Game createGame(Game game, int accountId);
    Game updateGame(int gameId);
    Game addUser(int userId);
    void deleteUser(int userId);
    void deleteGame(int accountId); // Organizer's account ID


}
