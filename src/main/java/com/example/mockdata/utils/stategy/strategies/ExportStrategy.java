package com.example.mockdata.utils.stategy.strategies;

import com.example.mockdata.domain.DataType;

import java.util.List;
import java.util.Map;

public interface ExportStrategy {
    String export(List<Map<String, DataType<?>>> data);

}
