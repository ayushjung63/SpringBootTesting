package com.ayush.testing.controller;

import com.ayush.testing.model.User;
import com.ayush.testing.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody User user, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        User login = userService.login(user);
        return ResponseEntity.ok(successMessage("User Login Successfully.", login));
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(successMessage("User fetched Successfully.", user));
    }
}
