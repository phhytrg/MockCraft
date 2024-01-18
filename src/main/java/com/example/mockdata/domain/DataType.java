package com.example.mockdata.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Document("dataTypes")
public abstract class DataType<T> {

    @Id
    private String id;
    protected T data;

    public DataType(T data) {
        this.data = data;
    }
}
