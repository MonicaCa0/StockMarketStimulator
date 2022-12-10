package com.techelevator.controller;

import com.techelevator.model.User;
import com.techelevator.services.ServiceLayer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
