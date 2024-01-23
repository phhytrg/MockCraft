package com.example.mockdata.domain;

import com.example.mockdata.domain.generate_by_external.RowNumber;
import com.example.mockdata.domain.generating_from_data.*;
import com.example.mockdata.domain.self_generating_datatype.*;
import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Getter
public enum EDataType {
    COLOR(Color.class, "Color"),
    COMPANY(CompanyName.class, "Company"),
    DEPARTMENT(Department.class, "Department"),
    JOB_TITLE(JobTitle.class, "Job Title"),
    LANGUAGE(Language.class, "Language"),
    TITLE(Title.class, "Title"),
    VIETNAM_UNIVERSITY(UniversityInVietnam.class, "Vietnam University"),
    VIETNAMESE_FIRSTNAME(VietnameseFirstName.class, "Vietnamese First Name"),
    VIETNAMESE_LASTNAME(VietnameseLastName.class, "Vietnamese Last Name"),
    ADDRESS_LINE2(AddressLine2.class, "Address Line 2"),
    GENDER(Gender.class, "Gender"),
    GUID(com.example.mockdata.domain.self_generating_datatype.GUID.class, "GUID"),
    HEX_COLOR(HexColor.class,  "Hex Color"),
    MY_BOOLEAN(MyBoolean.class, "My Boolean"),
    PASSWORD(Password.class, "Password"),
    SHIRT_SIZE(ShirtSize.class, "Shirt Size"),
    SHORT_HEX_COLOR(ShortHexColor.class, "Short Hex Color"),
    ROW_NUMBER(RowNumber.class, "Row Number"),
    CUSTOM(Custom.class, "Custom");

    private final Class<? extends DataType<?>> clazz;
    private final String name;
    EDataType(Class<? extends DataType<?>> clazz, String name) {
        this.clazz = clazz;
        this.name = name;
    }

    public String getClassName() {
        return clazz.getName();
    }

    public String getType() {
        Type baseType = clazz.getGenericSuperclass();

        if(baseType instanceof ParameterizedType parameterizedType){
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            if(typeArguments.length > 0){
                Type typeArgument = typeArguments[0];
                if (typeArgument instanceof Class<?> typeClass) {
                    return typeClass.getSimpleName();
                }
            }else{
                return "";
            }
        }else{
            return "";
        }
        return clazz.getSimpleName();
    }
}
