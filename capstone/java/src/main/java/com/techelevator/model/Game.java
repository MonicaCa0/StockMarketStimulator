package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Game {

    private int gameId;
    @JsonProperty("gameName")
    private String gameName;
    @JsonProperty( "dateFinished")
    @NotBlank(message = "Please insert the day that your game is finished")
    private LocalDate dateFinished;
    private LocalDate dateStart;
    @JsonProperty("playerUserId")
    private int playerUserId;
    private int playerAccountId;
    private int organizerAccountId;
    private int organizerUserId;


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

    public int getPlayerUserId() {
        return playerUserId;
    }

    public void setPlayerUserId(int playerUserId) {
        this.playerUserId = playerUserId;
    }

    public int getPlayerAccountId() {
        return playerAccountId;
    }

    public void setPlayerAccountId(int playerAccountId) {
        this.playerAccountId = playerAccountId;
    }

    public int getOrganizerAccountId() {
        return organizerAccountId;
    }

    public void setOrganizerAccountId(int organizerAccountId) {
        this.organizerAccountId = organizerAccountId;
    }

    public int getOrganizerUserId() {
        return organizerUserId;
    }

    public void setOrganizerUserId(int organizerUserId) {
        this.organizerUserId = organizerUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return gameId == game.gameId && playerUserId == game.playerUserId && playerAccountId == game.playerAccountId && organizerAccountId == game.organizerAccountId && organizerUserId == game.organizerUserId && gameName.equals(game.gameName) && dateFinished.equals(game.dateFinished) && dateStart.equals(game.dateStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameName, dateFinished, dateStart, playerUserId, playerAccountId, organizerAccountId, organizerUserId);
    }
}
