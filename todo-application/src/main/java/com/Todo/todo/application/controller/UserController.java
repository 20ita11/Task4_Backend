package com.Todo.todo.application.controller;

import com.Todo.todo.application.Model.UserCredentials;
import com.Todo.todo.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public String addUser(@RequestBody UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));

        userService.addUser(userCredentials);
        return "added succesfully";
    }

    @PostMapping("/check")
    public Boolean checkCredentails(@RequestBody UserCredentials userCredentials){
        return userService.checkCredentials(userCredentials);
    }

}
