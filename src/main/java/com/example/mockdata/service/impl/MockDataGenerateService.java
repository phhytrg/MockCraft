package com.example.mockdata.service.impl;

import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.payload.request.ColumnAttribute;
import com.example.mockdata.domain.payload.request.GenerateMockDataRequest;
import com.example.mockdata.service.MockDataService;
import com.example.mockdata.utils.StringUtils;
import com.example.mockdata.utils.builder.MockDataBuilder;
import com.example.mockdata.utils.factory.MockDataBuilderFactoryBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MockDataGenerateService {
    private final MockDataBuilderFactoryBean mockDataBuilderFactoryBean;
    public String generate(GenerateMockDataRequest request){
        Map<String, EDataType> fieldsMap = new LinkedHashMap<>();
        Map<String, Integer> nullPercentageMap = new HashMap<>();
        Map<String, List<String>> valuesMap = new HashMap<>();
        for(ColumnAttribute attr: request.getColumnAttributes()){
            fieldsMap.put(attr.getName(), EDataType.valueOf(attr.getType().toUpperCase()));
            nullPercentageMap.put(attr.getName(), attr.getNullPercentage());
            valuesMap.put(attr.getName(), StringUtils.split(attr.getValues(), ","));
        }

        MockDataBuilder builder = mockDataBuilderFactoryBean.createInstance()
                .withFields(fieldsMap)
                .withValues(valuesMap)
                .withNullPercentage(nullPercentageMap)
                .totalItem(request.getNumRows())
                .format(request.getFileFormat());

        return builder.build();
    }
}
