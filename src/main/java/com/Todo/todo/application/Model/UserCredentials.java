package com.Todo.todo.application.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("UserCredentials")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;
}
