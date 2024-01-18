package com.example.mockdata.config;

import com.example.mockdata.service.MockDataService;
import com.example.mockdata.utils.factory.MockDataBuilderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockDataConfig {

    @Bean
    public MockDataBuilderFactoryBean getMockDataBuilderFactoryBean(MockDataService mockdataService) {
        return new MockDataBuilderFactoryBean(mockdataService);
    }
}
