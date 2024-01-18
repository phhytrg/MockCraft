package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vietnamLastnames")
public class VietnameseLastName extends DataType<String> {
    public VietnameseLastName(String data) {
        super(data);
    }
}
