package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("colors")
public class Color extends DataType<String> {
    public Color(String data) {
        super(data);
    }
}
