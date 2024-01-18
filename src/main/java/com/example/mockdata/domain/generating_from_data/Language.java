package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("languages")
public class Language extends DataType<String> {
    public Language(String data) {
        super(data);
    }
}
