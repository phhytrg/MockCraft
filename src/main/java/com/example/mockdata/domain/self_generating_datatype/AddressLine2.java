package com.example.mockdata.domain.self_generating_datatype;

import com.example.mockdata.domain.DataType;

public class AddressLine2 extends DataType<String> implements SelfGenerateValue<String> {
    private final String[] areaNames = {"Room", "Po Box", "Apt", "Suite", "Floor"};
    public AddressLine2() {
        super();
        this.data = generate();
    }

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        String areaName = areaNames[this.random.nextInt(areaNames.length)];

        if(areaName.equals("Po Box")){
            int block = random.nextInt(1000,9999);
            stringBuilder.append(areaName).append(" ").append(block);
        }
        else if(areaName.equals("Floor")){
            int block = random.nextInt(0, 150);
            String ordinalSuffix = "th";
            if (block > 20 && block < 24) {
                int remnant = block % 10;
                switch (remnant) {

                    case 1: {
                        ordinalSuffix = "st";
                        break;
                    }
                    case 2: {
                        ordinalSuffix = "nd";
                        break;
                    }
                    case 3: {
                        ordinalSuffix = "rd";
                        break;
                    }
                }
            }
            stringBuilder.append(ordinalSuffix)
                    .append(" ")
                    .append(areaName);
        }
        else{
            int block = random.nextInt(0, 1500);
            stringBuilder.append(areaName).append(" ").append(block);
        }

        return stringBuilder.toString();
    }
}
