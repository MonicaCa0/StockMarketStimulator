package com.techelevator.service;

import com.techelevator.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayerDao {
    private UserDao userDao;

    public ServiceLayerDao(UserDao userDao) {
        this.userDao = userDao;
    }







}

