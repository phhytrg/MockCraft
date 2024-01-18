package com.example.mockdata.utils.factory;

import com.example.mockdata.service.MockDataService;
import com.example.mockdata.utils.builder.MockDataBuilder;
import org.springframework.stereotype.Component;

@Component
public class MockDataBuilderFactoryBean {

    private final MockDataService mockDataService;

    public MockDataBuilderFactoryBean(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    public MockDataBuilder createInstance() {
        return new MockDataBuilder(mockDataService);
    }
}
