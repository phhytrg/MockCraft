package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class ShirtSize extends DataType<String> implements SelfGenerateValue<String> {
    private final String[] sizes = {"S","M","L","XL","2XL", "3XL", "4XL"};

    public ShirtSize() {
        super();
        this.data = generate();
    }

    @Override
    public String generate() {
        return sizes[random.nextInt(sizes.length)];
    }
}
