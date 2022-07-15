package com.ayush.testing.service.impl;

import com.ayush.testing.model.User;
import com.ayush.testing.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return user;
        } else {
            throw new RuntimeException("Bad Credentials");
        }
    }

    @Override
    public User getUserById(Long id) {
        List<User> userList = Arrays.asList(
                new User(1L, "ayush", "ayush"),
                new User(2L, "anij", "anij"),
                new User(3L, "nabin", "nabin"),
                new User(4L, "parash", "parash")
        );
        User user = userList.stream().filter(x -> x.getId() == id).findAny().get();
        if (user == null) {
            throw new NoSuchElementException("User not found");
        }
        return user;
    }
}