package com.example.mockdata.utils.stategy.strategies;
import com.example.mockdata.domain.DataType;

import java.util.List;
import java.util.Map;


public class ExportCsvStrategy implements ExportStrategy {
    private static final String CSV_SEPARATOR = ",";
    @Override
    public String export(List<Map<String, DataType<?>>> data) {
        List<String> fieldNames  = data.get(0).keySet().stream().toList();

        StringBuilder stringBuilder = new StringBuilder();

        for (String fieldName : fieldNames) {
            stringBuilder.append(fieldName);
            stringBuilder.append(CSV_SEPARATOR);
        }
        stringBuilder.append("\n");

        for (Map<String, DataType<?>> map : data) {
            for (String fieldName : fieldNames) {
                DataType<?> dataItem = map.get(fieldName);
                if(dataItem == null){
                    stringBuilder.append(CSV_SEPARATOR);
                    continue;
                }
                stringBuilder.append(dataItem.getData());
                stringBuilder.append(CSV_SEPARATOR);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
