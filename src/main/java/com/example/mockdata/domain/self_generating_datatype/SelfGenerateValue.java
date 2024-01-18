package com.example.mockdata.domain.self_generating_datatype;

import java.util.Random;

public interface SelfGenerateValue<T> {
    Random random = new Random();
    default T generate(){
        return null;
    }
}
