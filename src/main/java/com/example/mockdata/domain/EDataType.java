package com.example.mockdata.domain;

import com.example.mockdata.domain.generate_by_external.RowNumber;
import com.example.mockdata.domain.generating_from_data.*;
import com.example.mockdata.domain.self_generating_datatype.*;
import lombok.Getter;

@Getter
public enum EDataType {
    COLOR(Color.class),
    COMPANY(CompanyName.class),
    DEPARTMENT(Department.class),
    JOB_TITLE(JobTitle.class),
    LANGUAGE(Language.class),
    TITLE(Title.class),
    VIETNAM_UNIVERSITY(UniversityInVietnam.class),
    VIETNAMESE_FIRSTNAME(VietnameseFirstName.class),
    VIETNAMESE_LASTNAME(VietnameseLastName.class),
    ADDRESS_LINE2(AddressLine2.class),
    GENDER(Gender.class),
    GUID(com.example.mockdata.domain.self_generating_datatype.GUID.class),
    HEX_COLOR(HexColor.class),
    MY_BOOLEAN(MyBoolean.class),
    PASSWORD(Password.class),
    SHIRT_SIZE(ShirtSize.class),
    SHORT_HEX_COLOR(ShortHexColor.class),
    ROW_NUMBER(RowNumber.class),
    CUSTOM(Custom.class);

    private final Class<? extends DataType<?>> clazz;
    EDataType(Class<? extends DataType<?>> clazz) {
        this.clazz = clazz;
    }

    public String getClassName() {
        return clazz.getName();
    }

}
