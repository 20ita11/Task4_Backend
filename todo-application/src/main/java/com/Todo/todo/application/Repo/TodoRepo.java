package com.Todo.todo.application.Repo;

import com.Todo.todo.application.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Long> {

    List<Todo> findAllByUserCredentials_Id(Long id);
}
