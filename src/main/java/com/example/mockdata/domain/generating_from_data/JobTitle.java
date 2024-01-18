package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jobTitles")
public class JobTitle extends DataType<String> {
    public JobTitle(String data) {
        super(data);
    }
}
