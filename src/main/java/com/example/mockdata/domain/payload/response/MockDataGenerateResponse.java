package com.example.mockdata.domain.payload.response;

import com.example.mockdata.domain.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MockDataGenerateResponse {
    private Integer totalItem;
    private String data;
}
