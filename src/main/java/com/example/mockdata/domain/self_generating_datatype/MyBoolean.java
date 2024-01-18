package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class MyBoolean extends DataType<Boolean> implements SelfGenerateValue<Boolean> {

    public MyBoolean() {
        super();
        this.data = generate();
    }

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
