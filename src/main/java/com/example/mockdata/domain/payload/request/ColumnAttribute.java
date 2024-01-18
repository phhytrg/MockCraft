package com.example.mockdata.domain.payload.request;

import com.example.mockdata.domain.EDataType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class ColumnAttribute {

    private String name;
    private String type;
    @JsonProperty("null_percentage")
    private int nullPercentage;

    @JsonProperty("custom_list")
    private String values;
}
