package com.techelevator.controller;


import com.techelevator.model.Game;
import com.techelevator.services.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;



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
    @RequestMapping(path="/players/{gameId}", method= RequestMethod.GET)
    public List<Game> getAllPlayers(@PathVariable int gameId){
        return serviceLayer.getAllPlayers(gameId);
    }


   @RequestMapping(path ="/{id}/create", method= RequestMethod.POST)
    public Game createGame(@RequestBody Game game, @PathVariable int id, Principal principal){
           return serviceLayer.createNewGame(game, principal, id);
   }

    @RequestMapping(path="/{id}")
    public List<Game> getAllGamesByOrganizerId(@PathVariable int id, Principal principal){
           return serviceLayer.getAllGamesByUserId(id, principal);
    }


    @RequestMapping(path="/{id}/addUser", method=RequestMethod.POST)
    public void addUser(@PathVariable int id, @RequestBody Game game, Principal principal){
        serviceLayer.addUser(game,id, principal);
    }


}
