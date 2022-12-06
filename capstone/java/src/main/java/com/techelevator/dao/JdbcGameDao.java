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
    public List<Game> getAllGames(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start. g.organizer_account_id, gh.user_id, gh.game_account_id "+
                "FROM game g " +
                "JOIN ON game_history gh g.game_id = gh.game_id  WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            games.add(mapToGame(rowSet));
        }

        return games;
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = new Game();
        String sql ="SELECT game_id, game_name, date_finished, date_start, organizer_account_id FROM game" +
                " WHERE game_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameId);
        if(rowSet.next()){
            game = mapToGame(rowSet);
        }

        return game;
    }

    @Override
    public Game createGame(Game game, int accountId) {
        LocalDate date = LocalDate.now();
        String sql = "INSERT INTO game (game_name, date_finished, date_start, organizer_account_id) " +
                "VALUE(?,?,?,?) RETURNING game_id" ;
        Integer gameId = jdbcTemplate.queryForObject(sql, Integer.class, game.getGameName(),game.getDateFinished(),date, accountId);


        return getGameById(gameId);
    }

    @Override
    public Game updateGame(int gameId) {
        return null;
    }

    @Override
    public Game addUser(int userId) {
        return null;
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void deleteGame(int accountId) {

    }

    private Game mapToGame(SqlRowSet result){
        Game game = new Game();
        game.setGameId(result.getInt("game_id"));
        game.setGameName(result.getString("game_name"));
        game.setDateFinished(result.getDate("date_finished").toLocalDate());
        game.setDateStart(result.getDate("date_start").toLocalDate());
        game.setOrganizer(result.getInt("organizer"));
        game.setUserId(result.getInt("user_id"));
        game.setAccountId(result.getInt("organizer_account_id"));
        return game;
    }

}
