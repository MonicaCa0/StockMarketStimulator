package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Game {

    private int gameId;
    private String gameName;
    private LocalDate dateFinished;
    private LocalDate dateStart;
    private int userId;
    private int organizer;

    public int getOrganizer() {
        return organizer;
    }

    public void setOrganizer(int organizer) {
        this.organizer = organizer;
    }

    private int accountId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public LocalDate getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDate dateFinished) {
        this.dateFinished = dateFinished;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return gameId == game.gameId && userId == game.userId && accountId == game.accountId && gameName.equals(game.gameName) && dateFinished.equals(game.dateFinished) && dateStart.equals(game.dateStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameName, dateFinished, dateStart, userId, accountId);
    }
}
