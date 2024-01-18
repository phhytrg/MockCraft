package com.example.mockdata.utils.factory;

import com.example.mockdata.domain.DataType;
import com.example.mockdata.domain.EDataType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
public class DataTypeFactory {

//    private final Map<EDataType, Class<? extends DataType>> classMap = new HashMap<>();
//
//    {
//        classMap.put(EDataType.COLOR, Color.class);
//        classMap.put(EDataType.COMPANY, CompanyName.class);
//        classMap.put(EDataType.DEPARTMENT, Department.class);
//        classMap.put(EDataType.JOB_TITLE, JobTitle.class);
//        classMap.put(EDataType.LANGUAGE, Language.class);
//        classMap.put(EDataType.VIETNAM_UNIVERSITY, UniversityInVietnam.class);
//        classMap.put(EDataType.VIETNAMESE_FIRSTNAME, VietnameseFirstName.class);
//        classMap.put(EDataType.VIETNAMESE_LASTNAME, VietnameseFirstName.class);
//    }

    public DataType<?> createInstance(EDataType className, String data) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<? extends DataType<?>> clazz = className.getClazz();
        if(clazz == null){
            throw new ClassNotFoundException("Class not found: " + className);
        }

        Constructor<? extends DataType<?>> constructor = clazz.getDeclaredConstructor(String.class);
        return constructor.newInstance(data);
    }

    public DataType<?> createInstanceForSelfGen(EDataType className) throws ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<? extends DataType<?>> clazz = className.getClazz();
        if(clazz == null){
            throw new ClassNotFoundException("Class not found: " + className);
        }

        Constructor<? extends DataType<?>> constructor = clazz.getDeclaredConstructor();
        return constructor.newInstance();
    }
}
