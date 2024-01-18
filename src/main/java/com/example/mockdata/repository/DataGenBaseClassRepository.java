package com.example.mockdata.repository;

import com.example.mockdata.domain.DataType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;

public interface DataGenBaseClassRepository extends MongoRepository<DataType<?>, String> {
    @Query(value="{ '_class' : ?0 }")
    @Cacheable("allData")
    Set<DataType<?>> findByClass(String className);
}
