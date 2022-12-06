package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao{
    private JdbcTemplate jdbcTemplate;

    JdbcGameDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_user_id, organizer_account_id "+
                "FROM game";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            games.add(mapToGameTableOnly(rowSet));
        }

        return games;
    }
    public List<Game> getAllGamesById(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start, g.organizer_user_id, g.organizer_account_id, gh.user_id, gh.game_account_id "+
                "FROM game g " +
                "JOIN ON game_history gh g.game_id = gh.game_id  WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            games.add(mapToGame(rowSet));
        }

        return games;
    }
    public List<Game> getGamesByOrganizer (int userId){
        List <Game> games = new ArrayList<>();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_user_id, organizer_account_id "+
                "FROM game  " +
                "  WHERE organizer_user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
        while(rowSet.next()){
            games.add(mapToGameTableOnly(rowSet));

        }
        return games;
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = new Game();
        String sql ="SELECT game_id, game_name, date_finished, date_start, organizer_account_id, organizer_user_id FROM game" +
                " WHERE game_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameId);
        if(rowSet.next()){
            game = mapToGameTableOnly(rowSet);
        }

        return game;
    }

    @Override
    public Game createGame(Game game, int accountId) {
        LocalDate date = LocalDate.now();
        String sql = "INSERT INTO game (game_name, date_finished, date_start, organizer_account_id, organizer_user_id) " +
                "VALUES (?,?,?,?,?) RETURNING game_id" ;
        Integer gameId = jdbcTemplate.queryForObject(sql, Integer.class, game.getGameName(),game.getDateFinished(),date, accountId, game.getOrganizerUserId());

        return getGameById(gameId);
    }

    @Override
    public Game updateGame(Game game) {
        return null;
    }

    @Override
    public Game addUser(int userId, int accountId) {
        // In the service layer we can call the JdbcPortfolioDao to create
        // a new account based on adding a user to the game and then

        return null;
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void deleteGame(int accountId) {

    }
    private Game mapToGameTableOnly(SqlRowSet result){
        Game game = new Game();
        game.setGameId(result.getInt("game_id"));
        game.setGameName(result.getString("game_name"));
        if(result.getDate("date_finished") != null) {
            game.setDateFinished(result.getDate("date_finished").toLocalDate());
        } if(result.getDate("date_start") != null) {
            game.setDateStart(result.getDate("date_start").toLocalDate());
        }
        game.setOrganizerAccountId(result.getInt("organizer_account_id"));
        game.setOrganizerUserId(result.getInt("organizer_user_id"));
        return game;
    }
    private Game mapToGame(SqlRowSet result){
        Game game = new Game();
        game.setGameId(result.getInt("game_id"));
        game.setGameName(result.getString("game_name"));
        if(result.getDate("date_finished") != null) {
            game.setDateFinished(result.getDate("date_finished").toLocalDate());
        } if(result.getDate("date_start") != null) {
            game.setDateStart(result.getDate("date_start").toLocalDate());
        }
        game.setOrganizerAccountId(result.getInt("organizer_account_id"));
        game.setOrganizerUserId(result.getInt("organizer_user_id"));
        game.setPlayerUserId(result.getInt("user_id"));
        game.setPlayerAccountId(result.getInt("account_id"));
        return game;
    }

}
