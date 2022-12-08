package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAllGames();
    List<Game> getAllGamesByOrganizer(int userId);
    List<Game> getAllPlayersInvitedToAGame(int gameId);
    List<Game> getAllApprovedPlayersInAGame(int gameId);
    List<Game> getAllGamesForPlayer(int playerId);
    Game getGameById(int gameId);
    Game createGame(Game game, int accountId);
    Game getGameByGameName(String gameName);
    Game addUser(Game game, int accountId);
    Game userApproveOrDeny(Game game, int gameId);
    List<Game> getPlayersPendingInvites(int playerId);
    Game getGameByPlayer(int playerId, int gameId);
    void updateGame(int gameId, Game newGame);
    void deletePlayer(int userId);
    void deleteGame(int accountId); // Organizer's account ID
    //ToDo Controller
/*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateExistingCard(@Valid @RequestBody Game newGame, @PathVariable int gameId) {
        gameService.updateExistingGame(gameId, newGame);
        }
 */




}
