package com.Todo.todo.application.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document("Todo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private String todoId;
    private String data;
    private Boolean status;
    private UserCredentials userCredentials;
}
