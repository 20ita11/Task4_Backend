package com.Todo.todo.application.service;

import com.Todo.todo.application.Model.UserCredentials;
import com.Todo.todo.application.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserCredentials userCredentials) {

        userRepo.save(userCredentials);
    }

    public Boolean checkCredentials(UserCredentials userCredentials) {
        UserCredentials users = userRepo.findByEmail(userCredentials.getEmail()).get();
        if(passwordEncoder.matches(userCredentials.getPassword(),users.getPassword())){
            return true;
        }
        return false;
    }
}
