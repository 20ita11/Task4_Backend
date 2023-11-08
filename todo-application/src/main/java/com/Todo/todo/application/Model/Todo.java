package com.Todo.todo.application.Model;

import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document("Todo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    private String todoId;
    private String data;
    private Boolean status;
    private UserCredentials userCredentials;
}
