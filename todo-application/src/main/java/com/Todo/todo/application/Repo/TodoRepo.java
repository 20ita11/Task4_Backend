package com.Todo.todo.application.Repo;

import com.Todo.todo.application.Model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends MongoRepository<Todo,String> {

    List<Todo> findAllByUserCredentials_Id(String id);
}
