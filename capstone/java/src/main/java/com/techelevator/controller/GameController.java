package com.techelevator.controller;


import com.techelevator.model.Game;
import com.techelevator.model.GameDTO;
import com.techelevator.model.Portfolio;
import com.techelevator.services.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path="/games")
public class GameController {
   private final ServiceLayer serviceLayer;

   public GameController(ServiceLayer serviceLayer){
       this.serviceLayer = serviceLayer;
   }

    @RequestMapping(path="", method= RequestMethod.GET)
    public List<Game> getAllGames(){
        return serviceLayer.getAllGames();
    }
    //returns all players invited
    @RequestMapping(path="/{gameId}/players", method= RequestMethod.GET)
    public List<Game> getAllPlayersInvited(@PathVariable int gameId, Principal principal){
        return serviceLayer.getAllPlayersInvited(gameId, principal);
    }
    @RequestMapping(path="/{gameId}/endGame", method= RequestMethod.GET)
    public List<Portfolio> endGame(@PathVariable int gameId, Principal principal){
        return serviceLayer.endGame(gameId);
    }
    //returns all players that approved the request
    @RequestMapping(path="/{gameId}/players/approved", method= RequestMethod.GET)
    public List<Game> getAllPlayersApproved(@PathVariable int gameId, Principal principal){
        return serviceLayer.getAllPlayersApproved(gameId, principal);
    }

   @RequestMapping(path ="/{id}/create/", method= RequestMethod.POST)
    public Game createGame(@RequestBody GameDTO gameDTO, @PathVariable int id, Principal principal){
           return serviceLayer.createNewGame(gameDTO, id, principal);
   }

    @RequestMapping(path="/{id}/organizer")
    public List<Game> getAllGamesByOrganizerId(@PathVariable int id, Principal principal){
           return serviceLayer.getAllGamesByUserId(id, principal);
    }

    @RequestMapping(path="/{id}/addUser", method=RequestMethod.POST)
    public Game addUser(@PathVariable int id, @RequestBody Game game, Principal principal){
        return serviceLayer.addUser(game,id, principal);
    }
    @RequestMapping(path="/{playerId}/invites", method=RequestMethod.GET)
    public List<Game> getPendingInvites(@PathVariable int playerId, Principal principal){

        return serviceLayer.getPendingInvites(playerId,principal);
    }

        @RequestMapping(path="/{playerId}/response/{gameId}", method=RequestMethod.POST)

    public Game approveOrDenyRequest(@PathVariable int playerId, @PathVariable int gameId, @RequestBody Game game, Principal principal){
       return serviceLayer.approveOrDenyRequest(playerId,gameId,game,principal);

    }
    @RequestMapping(path="/{playerId}/player")
     public List<Game> getAllGamesForPlayer(@PathVariable int playerId, Principal principal){
       return serviceLayer.getAllGamesForPlayer(playerId, principal) ;
    }
//    @RequestMapping(path="/{gameId}/gameEnd")
//    public List<Portfolios> getAllPortfoliosForEndOfGame(@PathVariable int gameId){
//        return serviceLayer.
//    }


}
