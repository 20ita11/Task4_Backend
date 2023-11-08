package com.Todo.todo.application.Repo;

import com.Todo.todo.application.Model.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserCredentials,String> {
    Optional<UserCredentials> findByEmail(String email);
}
