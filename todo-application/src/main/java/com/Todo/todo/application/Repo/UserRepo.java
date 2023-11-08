package com.Todo.todo.application.Repo;

import com.Todo.todo.application.Model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserCredentials,Long> {
    Optional<UserCredentials> findByEmail(String email);
}
