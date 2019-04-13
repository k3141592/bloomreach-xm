package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.swagger.model.User;

import java.util.List;

public interface UserService {

    /**
     * Get a list with all users
     * @return
     */
    List<User> getAllUsers();


    /**
     * Get a user by its userId
     * @param userId user id
     * @return The user
     * @throws ItemNotFoundException if not found
     */
    User getUserById(Integer userId) throws ItemNotFoundException;
}
