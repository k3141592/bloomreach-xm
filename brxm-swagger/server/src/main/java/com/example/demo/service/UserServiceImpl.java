package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.swagger.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    Map<Integer, User> users = new HashMap<>(2);

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("User one");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("User two");
        users.put(user2.getId(), user2);
    }

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    @Override
    public User getUserById(Integer userId) throws ItemNotFoundException {
        User user = users.get(userId);
        if (user == null) {
            throw new ItemNotFoundException("Not found");
        } else {
            return users.get(userId);
        }
    }
}
