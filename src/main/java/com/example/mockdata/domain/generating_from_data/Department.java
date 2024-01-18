package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
public class Department extends DataType<String> {
    public Department(String data) {
        super(data);
    }
}
