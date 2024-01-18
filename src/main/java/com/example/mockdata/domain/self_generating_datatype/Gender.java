package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class Gender extends DataType<String> implements SelfGenerateValue<String> {
    private final String[] genders = {"Male", "Female", "Non Binary"};
    public Gender() {
        super();
        this.data = generate();
    }

    @Override
    public String generate() {
        return genders[random.nextInt(genders.length)];
    }
}
