package com.example.demo.controller;

import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.service.UserService;
import com.example.swagger.api.UserApi;
import com.example.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<User> getUserById(Integer userId) {
        ResponseEntity<User> responseEntity;
        try {
            User user = userService.getUserById(userId);
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
