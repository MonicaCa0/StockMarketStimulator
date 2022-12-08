package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao {
    private JdbcTemplate jdbcTemplate;

    JdbcGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_user_id, organizer_account_id " +
                "FROM game";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            games.add(mapToGameTableOnly(rowSet));
        }

        return games;
    }


    public List<Game> getGamesByOrganizer(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_user_id, organizer_account_id " +
                "FROM game  " +
                "  WHERE organizer_user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            games.add(mapToGameTableOnly(rowSet));

        }
        return games;
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = new Game();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_account_id, organizer_user_id FROM game" +
                " WHERE game_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameId);
        if (rowSet.next()) {
            game = mapToGameTableOnly(rowSet);
        }

        return game;
    }

    @Override
    public Game getGameByGameName(String gameName) {
        Game game = new Game();
        String sql = "SELECT game_id, game_name, date_finished, date_start, organizer_account_id, organizer_user_id FROM game" +
                " WHERE game_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameName);
        if (rowSet.next()) {
            game = mapToGameTableOnly(rowSet);
        }

        return game;
    }

    @Override
    public Game createGame(Game game, int accountId) {
        LocalDate date = LocalDate.now();
        String sql = "INSERT INTO game (game_name, date_finished, date_start, organizer_account_id, organizer_user_id) " +
                "VALUES (?,?,?,?,?) RETURNING game_id";
        Integer gameId = jdbcTemplate.queryForObject(sql, Integer.class, game.getGameName(), game.getDateFinished(), date, accountId, game.getOrganizerUserId());

        return getGameById(gameId);
    }

    //ToDo change update game to be a boolean and also pass in a newGame
    @Override
    public boolean updateGame(int gameId, Game newGame) {
        LocalDate date = LocalDate.now();
        String sql = "UPDATE game  SET game_name = ?, date_finished = ?, date_start = ?, organizer_account_id = ?, organizer_user_id = ? " +
                "WHERE game_id = ?";
        return jdbcTemplate.update(sql, newGame.getGameName(), newGame.getDateFinished(), newGame.getDateStart(), newGame.getOrganizerAccountId(), newGame.getOrganizerUserId(), gameId) == 1;
    }

//ToDo Service layer when we create the service layer
/*
    public void updateExistingGame(int gameId, Game newGame) {gameDao.update(gameId, newGame);}
 */


    public void addUser(Game game, int accountId) {
        String sql = "INSERT INTO game_history(game_id, user_id, account_id) VALUES(?,?,?) RETURNING game_history_id";
        jdbcTemplate.update(sql, game.getGameId(), game.getPlayerUserId(), accountId);
    }
        //ToDo Controller




    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM game_history WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void deleteGame(int accountId) {
        String sql = "DELETE FROM game WHERE game_id = ?";
        jdbcTemplate.update(sql, accountId);

        }


        private Game mapToGameHistoryTableOnly (SqlRowSet result){
            Game game = new Game();
            game.setGameId(result.getInt("game_id"));
            game.setPlayerUserId(result.getInt("user_id"));
            game.setPlayerAccountId(result.getInt("account_id"));
            return game;
        }


        private Game mapToGameTableOnly (SqlRowSet result){
            Game game = new Game();
            game.setGameId(result.getInt("game_id"));
            game.setGameName(result.getString("game_name"));
            if (result.getDate("date_finished") != null) {
                game.setDateFinished(result.getDate("date_finished").toLocalDate());
            }
            if (result.getDate("date_start") != null) {
                game.setDateStart(result.getDate("date_start").toLocalDate());
            }
            game.setOrganizerAccountId(result.getInt("organizer_account_id"));
            game.setOrganizerUserId(result.getInt("organizer_user_id"));
            return game;
        }
        private Game mapToGameAndHistoryTable (SqlRowSet result){
            Game game = new Game();
            game.setGameId(result.getInt("game_id"));
            game.setGameName(result.getString("game_name"));
            if (result.getDate("date_finished") != null) {
                game.setDateFinished(result.getDate("date_finished").toLocalDate());
            }
            if (result.getDate("date_start") != null) {
                game.setDateStart(result.getDate("date_start").toLocalDate());
            }
            game.setOrganizerAccountId(result.getInt("organizer_account_id"));
            game.setOrganizerUserId(result.getInt("organizer_user_id"));
            game.setPlayerUserId(result.getInt("user_id"));
            game.setPlayerAccountId(result.getInt("account_id"));
            return game;
        }

    }

