package com.techelevator.controller;

import com.techelevator.model.LeaderboardDTO;
import com.techelevator.model.User;
import com.techelevator.services.ServiceLayer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UsersController {
    private final ServiceLayer serviceLayer;

    public UsersController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping(path="/users")
    public List<User> getAllUsers(){
        return serviceLayer.getAllUsers();
    }
    @RequestMapping(path="/users/{id}/")
    public User getUserById(@PathVariable int id){
        return serviceLayer.getUserById(id);
    }
    @RequestMapping(path="/users/{username}")
    public int findUserByUsername(@PathVariable String username){
        return serviceLayer.findIdByUsername(username);
    }

    @RequestMapping(path="/users/leaders", method = RequestMethod.GET)
    public List<LeaderboardDTO> getLeaderboard() {return serviceLayer.getLeaderboard();}
}
