package com.example.mockdata.domain.generating_from_data;


import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Title extends DataType<String> {
    public Title(String data) {
        super(data);
    }
}
