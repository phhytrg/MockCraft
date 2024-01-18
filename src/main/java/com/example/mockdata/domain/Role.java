package com.example.mockdata.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@RequiredArgsConstructor
@Setter
@Getter
@Document("roles")
public class Role {
    @Id
    private String id;

    private final ERole name;

}
