package com.example.mockdata.domain.generating_from_data;

import com.example.mockdata.domain.DataType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vietnamUniversities")
public class UniversityInVietnam extends DataType<String> {
    public UniversityInVietnam(String data) {
        super(data);
    }
}
