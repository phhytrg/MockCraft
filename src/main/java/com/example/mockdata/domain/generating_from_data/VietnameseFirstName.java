package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("vietnamFirstnames")
public class VietnameseFirstName extends DataType<String> {
    public VietnameseFirstName(String data) {
        super(data);
    }
}
