package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("companyNames")
public class CompanyName extends DataType<String> {
    public CompanyName(String data) {
        super(data);
    }
}
