package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
        String sql = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start. g.organizer, gh.user_id, gh.game_account_id "+
                "FROM game g " +
                "JOIN ON game_history gh g.game_id = gh.game_id  WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(rowSet.next()){
            games.add(mapToGame(rowSet));
        }

        return games;
    }

    @Override
    public Game createGame(Game game) {
        return null;
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
        game.setDateFinished(result.getDate("date_finished"));
        game.setDateStart(result.getDate("date_start"));
        game.setOrganizer(result.getInt("organizer"));
        game.setUserId(result.getInt("user_id"));
        game.setAccountId(result.getInt("account_id"));
        return game;
    }

}
