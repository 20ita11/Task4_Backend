package com.Todo.todo.application.service;

import com.Todo.todo.application.DTO.TodoDTO;
import com.Todo.todo.application.Model.Todo;
import com.Todo.todo.application.Model.UserCredentials;
import com.Todo.todo.application.Repo.TodoRepo;
import com.Todo.todo.application.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public String add(Todo todo) {
        todoRepo.save(todo);
        return "added";
    }

    public ResponseEntity<?> getTasks(String email) {
        UserCredentials userData = userRepo.findByEmail(email).get();
        List<Todo> todoList = todoRepo.findAllByUserCredentials_Id(userData.getId());
        List<TodoDTO> todoDTOList = new ArrayList<>();
        for(Todo todo : todoList){
            TodoDTO todoDTO = TodoDTO.builder()
                    .data(todo.getData())
                    .status(todo.getStatus())
                    .taskId(todo.getTodoId())
                    .build();
            todoDTOList.add(todoDTO);
        }

        return new ResponseEntity<>(todoDTOList, HttpStatus.OK);
    }

    public String deleteTasks(Long id) {
        todoRepo.deleteById(id);
        return "deleted";
    }

    public ResponseEntity<?> update(Todo todo) {
        todoRepo.save(todo);
        return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
    }
}
