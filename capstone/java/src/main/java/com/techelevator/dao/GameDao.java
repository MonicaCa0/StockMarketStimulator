package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAllGames();
    List<Game> getGamesByOrganizer(int userId);
    Game getGameById(int gameId);
    Game createGame(Game game, int accountId);

    Game getGameByGameName(String gameName);
    void addUser(Game game, int accountId);
   boolean updateGame(int gameId, Game newGame);
    void deleteUser(int userId);
    void deleteGame(int accountId); // Organizer's account ID
    //ToDo Controller
/*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateExistingCard(@Valid @RequestBody Game newGame, @PathVariable int gameId) {
        gameService.updateExistingGame(gameId, newGame);
        }
 */




}
