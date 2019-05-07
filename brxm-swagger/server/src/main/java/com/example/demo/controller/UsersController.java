package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.swagger.api.UsersApi;
import com.example.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class UsersController implements UsersApi {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
