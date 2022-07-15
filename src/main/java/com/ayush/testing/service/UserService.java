package com.ayush.testing.service;

import com.ayush.testing.model.User;

public interface UserService {

    User login(User user);

    User getUserById(Long id);
}
