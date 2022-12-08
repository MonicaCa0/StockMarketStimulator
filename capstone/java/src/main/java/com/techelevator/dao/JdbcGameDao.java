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


    public List<Game> getAllGamesByOrganizer(int userId) {
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

    public void updateGame(int gameId, Game newGame) {
        String sql = "UPDATE game  SET game_name = ?, date_finished = ?, date_start = ?, organizer_account_id = ?, organizer_user_id = ? " +
                "WHERE game_id = ?";
       jdbcTemplate.update(sql, newGame.getGameName(), newGame.getDateFinished(), newGame.getDateStart(), newGame.getOrganizerAccountId(), newGame.getOrganizerUserId(), gameId);
    }


    public Game addUser(Game game, int accountId) {
        String sql = "INSERT INTO game_history (game_id, user_id, account_id, approval_id) " +
                "VALUES (?,?,?,?) ";

        int gameId = game.getGameId();
        jdbcTemplate.update(sql, gameId, game.getPlayerUserId(), accountId, 1);
        String sql2 = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start, g.organizer_user_id, g.organizer_account_id, gh.user_id AS user_id, gh.game_id, gh.account_id AS account_id, gh.approval_id, a.approval_desc "+
                "FROM game g " +
                "JOIN game_history gh ON g.game_id = gh.game_id  WHERE g.game_id = ? AND gh.user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql2, gameId, game.getPlayerUserId());
        if (result.next()) {
            game = mapToGameAndHistoryTable(result);
        }
        return game;
    }


    public Game userApprove(Game game,  int approvalId){
        String sql = "UPDATE INTO game_history SET approval_id = ?" +
                "VALUES(?) WHERE game_id = ? AND account_id = ?";
        jdbcTemplate.update(sql, approvalId, game.getGameId(), game.getPlayerAccountId());

        return getGameById(game.getGameId());

    }

    public List<Game> getAllPlayersInAGame(int gameId){
        List<Game> players = new ArrayList<>();
        String approvalDesc = "Approved";
        String sql = "SELECT g.game_id, g.game_name, g.date_finished, g.date_start, g.organizer_user_id, g.organizer_account_id, gh.user_id, gh.game_id, gh.account_id, gh.approval_id, a.approval_desc  "+
                "FROM game g " +
        "JOIN game_history gh ON g.game_id = gh.game_id  " +
                "JOIN approval a ON gh.approval_id = a.approval_id " +
                "WHERE g.game_id = ? AND a.approval_desc = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, gameId, approvalDesc);
        while (result.next()) {
            players.add(mapToGameAndHistoryTable(result));

        }
        return players;

    }


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
            game.setApprovalId(result.getInt("approval_id"));
            game.setApprovalId(result.getInt("approval_desc"));
            return game;
        }

    }

