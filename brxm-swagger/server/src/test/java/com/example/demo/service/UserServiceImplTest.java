package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.swagger.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    /**
     * Check if the list of users is not empty
     */
    @Test
    public void getAllUsersTest() {
        List<User> allUsers = userService.getAllUsers();
        Assert.assertTrue("There are users", !allUsers.isEmpty());
    }

    /**
     * Happy flow test for method {@link UserServiceImpl#getUserById(int)}
     * @throws ItemNotFoundException
     */
    @Test
    public void getUserByIdTest() throws ItemNotFoundException {
        User user = userService.getUserById(1);
        Assert.assertEquals("Check user", new Integer(1), user.getId());
    }

    /**
     * Item not found test for method {@link UserServiceImpl#getUserById(int)}
     * @throws ItemNotFoundException
     */
    @Test (expected = ItemNotFoundException.class)
    public void getUserByIdNotFound() throws ItemNotFoundException {
        userService.getUserById(-1);
    }

}