package com.example.mockdata.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "users")
@RequiredArgsConstructor
@Setter
@Getter
public class User {
    @Id
    private String id;
    @Indexed(unique=true)
    private final String username;
    private final String password;
    private final String name;
    private Set<Role> roles;

}
