package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class Password extends DataType<String> implements SelfGenerateValue<String> {
    private final char[] upperChars;
    private final char[] lowerChars;
    private final char[] digits;
    private final char[] specialChars = {'@','$','!','%','*','?','&'};
    public Password() {
        super();
        this.upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        this.lowerChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        this.digits = "0123456789".toCharArray();
        this.data = generate();
    }

    @Override
    public String generate() {
        int upperCharsLength = upperChars.length;
        int lowerCharsLength = lowerChars.length;
        int digitsLength = digits.length;
        int specialCharsLength = specialChars.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(upperChars[random.nextInt(upperCharsLength)])
                .append(lowerChars[random.nextInt(lowerCharsLength)])
                .append(digits[random.nextInt(digitsLength)])
                .append(specialChars[random.nextInt(specialCharsLength)]);

        int length = random.nextInt(4, 10);
        for(int i = 0; i < length; i ++){
            int index = random.nextInt(upperCharsLength + lowerCharsLength + digitsLength + specialCharsLength);
            if (index < upperCharsLength) {
                stringBuilder.append(upperChars[index]);
            } else if (index < upperCharsLength + lowerCharsLength) {
                stringBuilder.append(upperChars[index - upperCharsLength]);

            } else if (index < upperCharsLength + lowerCharsLength + digitsLength) {
                stringBuilder.append(upperChars[index - upperCharsLength - lowerCharsLength]);

            } else{
                stringBuilder.append(upperChars[index - upperCharsLength - lowerCharsLength - digitsLength]);
            }
        }
        return stringBuilder.toString();
    }
}
