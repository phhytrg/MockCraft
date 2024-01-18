package com.example.mockdata.domain.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class GenerateMockDataRequest {
    @JsonProperty("num_rows")
    private int numRows;
    @JsonProperty("file_format")
    private String fileFormat;
    @JsonProperty("column_attributes")
    private List<ColumnAttribute> columnAttributes;
}
