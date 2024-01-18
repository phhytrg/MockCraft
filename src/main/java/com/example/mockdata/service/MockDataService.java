package com.example.mockdata.service;

import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.DataType;

import java.util.Set;

public interface MockDataService {
    void insertData(String path, EDataType tableName);

    Set<DataType<?>> getDataByClass(String className);

    DataType<?> createInstance(EDataType type);

}
