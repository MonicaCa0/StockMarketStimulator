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
   @RequestMapping(path ="/{id}/create", method= RequestMethod.POST)
    public Game createGame(@RequestBody Game game, @PathVariable int id, Principal principal){
       int userId = serviceLayer.findIdByUsername(principal.getName());
       if(id == userId) {
           game.setOrganizerUserId(userId);
           return serviceLayer.createNewGame(game);
       } else {
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }
   }

    @RequestMapping(path="/games/{id}")
    public List<Game> getAllGames(@PathVariable int id, Principal principal){
       int checkId = serviceLayer.findIdByUsername(principal.getName());
       if(checkId == id) {
           return serviceLayer.getAllGamesByUserId(id);
       } else{
           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to access this resource");
       }
    }


}
