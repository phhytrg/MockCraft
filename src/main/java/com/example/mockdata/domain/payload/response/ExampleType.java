package com.example.mockdata.domain.payload.response;

import com.example.mockdata.domain.DataType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExampleType {
    private String name;
    private String type;
    private String typeName;
    List<String> example;
}
