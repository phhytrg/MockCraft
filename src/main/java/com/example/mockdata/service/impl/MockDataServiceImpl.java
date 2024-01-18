package com.example.mockdata.service.impl;

import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.DataType;
import com.example.mockdata.domain.self_generating_datatype.SelfGenerateValue;
import com.example.mockdata.utils.factory.DataTypeFactory;
import com.example.mockdata.repository.DataGenBaseClassRepository;
import com.example.mockdata.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
public class MockDataServiceImpl implements MockDataService {
    private final ResourceLoader resourceLoader;
    private final DataTypeFactory classFactory;
    private final DataGenBaseClassRepository repository;
    private final Random random = new Random();

    @Autowired
    public MockDataServiceImpl(@Qualifier("webApplicationContext") ResourceLoader resourceLoader,
                               DataTypeFactory classFactory,
                               DataGenBaseClassRepository repository) {
        this.resourceLoader = resourceLoader;
        this.classFactory = classFactory;
        this.repository = repository;
    }

    @Override
    public void insertData(String path, EDataType tableName) {
        try {
            Resource resource = resourceLoader.getResource(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;

            if ((line = reader.readLine()) != null) {
                do {
                    //Get class
                    DataType<?> entity = classFactory.createInstance(tableName, line);
                    repository.save(entity);
                } while ((line = reader.readLine()) != null);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<DataType<?>> getDataByClass(String className) {
        return repository.findByClass(className);
    }

    @Override
    public DataType<?> createInstance(EDataType type) {
        if(SelfGenerateValue.class.isAssignableFrom(type.getClazz())){
            try {
                return classFactory.createInstanceForSelfGen(type);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            List<DataType<?>> items = getDataByClass(type.getClassName())
                    .stream().toList();
            return items.get(random.nextInt(items.size()));
        }
    }


}
