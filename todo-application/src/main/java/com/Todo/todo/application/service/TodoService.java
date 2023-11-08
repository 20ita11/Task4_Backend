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
        System.out.println(todo);
        todoRepo.save(todo);
        return "added";
    }

    public ResponseEntity<?> getTasks(String email) {
        UserCredentials userData = userRepo.findByEmail(email).get();
        List<Todo> todoList = todoRepo.findAllByUserCredentials_Id(userData.getId());
        List<TodoDTO> todoDTOList = new ArrayList<>();
        for(Todo todo : todoList){
            TodoDTO todoDTO = TodoDTO.builder()
                    .uid(todo.getUserCredentials().getId())
                    .data(todo.getData())
                    .status(todo.getStatus())
                    .taskId(todo.getTodoId())
                    .build();
            todoDTOList.add(todoDTO);
        }
        if(todoList.isEmpty()){
            TodoDTO todoDTO = TodoDTO.builder()
                    .uid(userData.getId())
                    .build();
            todoDTOList.add(todoDTO);
        }
        return new ResponseEntity<>(todoDTOList, HttpStatus.OK);
    }

    public String deleteTasks(String id) {
        todoRepo.deleteById(id);
        return "deleted";
    }

    public ResponseEntity<?> update(Todo todo) {

        Optional<Todo> todo1 = todoRepo.findById(todo.getTodoId());
        if(todo1.isEmpty()){
            return new ResponseEntity<>("no data found",HttpStatus.OK);
        }

        Todo tododata = todo1.get();
        tododata.setTodoId(tododata.getTodoId());
        tododata.setData(todo.getData());
        tododata.setStatus(todo.getStatus());

        todoRepo.save(tododata);
        return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
    }
}
