package com.example.mockdata.domain.payload.response;

import com.example.mockdata.domain.DataType;
import lombok.Data;

import java.util.List;

@Data
public class ExampleType {
    private String name;
    private String type;
    List<DataType<?>> example;
}
