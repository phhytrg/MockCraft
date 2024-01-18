package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class GUID extends DataType<String> implements SelfGenerateValue<String> {
    private final char[] hexChars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e'};
    public GUID() {
        super();
        this.data = generate();
    }

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 36; i++){
            stringBuilder.append(hexChars[random.nextInt(hexChars.length)]);
            if(i % 4 == 0 && i != 0 && i < 21){
                stringBuilder.append('-');
            }
        }
        return stringBuilder.toString();

    }
}
