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
    public List<Game> getAllGamesByPlayerId(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start, g.organizer_user_id, g.organizer_account_id, gh.user_id AS user_id, gh.game_id, gh.account_id "+
                "FROM game g " +
                "JOIN game_history gh ON g.game_id = gh.game_id  WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            games.add(mapToGameAndHistoryTable(rowSet));
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
    public Game getGameByOrganizer (int userId){
        Game game = new Game();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_user_id, organizer_account_id "+
                "FROM game  " +
                "  WHERE organizer_user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
        if(rowSet.next()){
            game = (mapToGameTableOnly(rowSet));

        }
        return game;
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
    public Game addUser(Game game, int accountId) {
        Game newGame = new Game();
        String sql = "INSERT INTO game_history (game_id, user_id, account_id) " +
                "VALUES (?,?,?) " ;
         jdbcTemplate.update(sql, game.getGameId(), game.getPlayerUserId(), accountId);
         String sql2 = "SELECT game_id, user_id, account_id FROM game_history WHERE game_id = ?";
         SqlRowSet result = jdbcTemplate.queryForRowSet(sql2, game.getGameId());
         if(result.next()){
             newGame = mapToGameHistoryTableOnly(result);
         }
        return newGame;
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void deleteGame(int accountId) {


    }
    private Game mapToGameHistoryTableOnly(SqlRowSet result){
        Game game = new Game();
        game.setGameId(result.getInt("game_id"));
        game.setPlayerUserId(result.getInt("user_id"));
        game.setPlayerAccountId(result.getInt("account_id"));
        return game;
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

    private Game mapToGameAndHistoryTable(SqlRowSet result){
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
