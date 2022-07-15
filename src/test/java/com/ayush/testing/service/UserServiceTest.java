package com.ayush.testing.service;

import com.ayush.testing.model.User;
import com.ayush.testing.service.UserService;
import com.ayush.testing.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void initUserService() {
        userService = new UserServiceImpl();
    }


    @Test
    @DisplayName("Login with Bad Credentials")
    public void loginTestWithBadCredentials() {
        User user = new User("user", "user");
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> userService.login(user));
        Assertions.assertEquals("Bad Credentials", exception.getMessage());

    }

    @Test
    @DisplayName("Login with Valid Credentials")
    public void loginTestWithValidCredentials() {
        User user = new User("admin", "admin");
        User login = userService.login(user);
        Assertions.assertEquals(login, user);
    }

    @Test
    @DisplayName("Login with Null Credentials")
    public void loginTestWithNullCredentials() {
        User user = new User();
        Assertions.assertThrows(NullPointerException.class, () -> userService.login(user));
    }


    @Test
    @DisplayName("Getting User with Existing UserId")
    public void getUserByIdTest() {
        Long userId = 1L;
        User user = userService.getUserById(userId);
        Assertions.assertEquals(userId, user.getId());
    }

    @Test
    @DisplayName("Getting User with Null UserId")
    public void getUserByNullIdTest() {
        Long userId = 5L;
        Assertions.assertThrows(NoSuchElementException.class, () -> userService.getUserById(userId));
    }
}
