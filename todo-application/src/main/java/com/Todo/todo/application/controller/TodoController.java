package com.Todo.todo.application.controller;

import com.Todo.todo.application.Model.Todo;
import com.Todo.todo.application.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("addTodo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.add(todo);
    }

    @GetMapping("/getTasks/{email}")
    public ResponseEntity<?> getTasks(@PathVariable String email){
        return todoService.getTasks(email);
    }

    @PutMapping("/updateTask")
    public ResponseEntity<?> updateTask(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("deleteTasks/{id}")
    public String deleteTasks(@PathVariable Long id){
        return todoService.deleteTasks(id);
    }
}
