package com.example.mockdata.utils.builder;

import com.example.mockdata.domain.Custom;
import com.example.mockdata.domain.DataType;
import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.generate_by_external.RowNumber;
import com.example.mockdata.service.MockDataService;
import com.example.mockdata.utils.stategy.context.ExportContext;
import com.example.mockdata.utils.stategy.strategies.ExportCsvStrategy;
import com.example.mockdata.utils.stategy.strategies.ExportJsonStrategy;
import com.example.mockdata.utils.stategy.strategies.ExportStrategy;

import java.util.*;

public class MockDataBuilder {
    private static final String CSV_SEPARATOR = ",";
    private String format = "json";
    private int totalItem = 1;
    private Map<String, EDataType> fields = new HashMap<>();
    private Map<String, List<String>> valuesMap = new HashMap<>();
    private final MockDataService mockDataService;
    private Map<String, Integer> nullPercentageFields
            = new HashMap<>();

    public MockDataBuilder(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    public MockDataBuilder withFields(Map<String, EDataType> fields){
        this.fields = fields;
        return this;
    }
    public MockDataBuilder format(String format){
        this.format = format;
        return this;
    }

    public MockDataBuilder totalItem(int totalItem){
        this.totalItem = totalItem;
        return this;
    }
    public MockDataBuilder withNullPercentage(Map<String, Integer> nullPercentageMap) {
        this.nullPercentageFields = nullPercentageMap;
        return this;
    }
    public String build(){
        List<Map<String, DataType<?>>> data = getBuildData();

        return switch (this.format) {
            case "json" -> {
                ExportContext exportContext = new ExportContext(new ExportJsonStrategy());
                yield exportContext.export(data);
            }
            case "csv" -> {
                ExportContext exportContext = new ExportContext(new ExportCsvStrategy());
                yield exportContext.export(data);
            }
            default -> null;
        };
    }

    private List<Map<String, DataType<?>>> getBuildData(){
        List<Map<String, DataType<?>>> result = new ArrayList<>();
        List<String> fieldNames  = this.fields.keySet().stream().toList();

        for(int i = 0; i < totalItem; i++){
            Map<String, DataType<?>> map = new LinkedHashMap<>();
            for (String fieldName : fieldNames) {
                EDataType type = this.fields.get(fieldName);
                DataType<?> data;

                if(nullPercentageFields.containsKey(fieldName)){
                    int nullPercentage = nullPercentageFields.get(fieldName);
                    if(nullPercentage > 0){
                        int random = new Random().nextInt(100);
                        if(random < nullPercentage){
                            map.put(fieldName, null);
                            continue;
                        }
                    }
                }

                if(type.getClazz() != RowNumber.class){
                    data = createInstance(type, valuesMap.get(fieldName));
                }
                else{
                    data = new RowNumber(i + 1);
                }
                map.put(fieldName, data);
            }
            result.add(map);
        }
        return result;
    }

    DataType<?> createInstance(EDataType type, List<String> values){
        if(values == null || values.isEmpty()){
            return mockDataService.createInstance(type);
        }
        else{
            int random = new Random().nextInt(values.size());
            return new Custom(values.get(random));
        }
    }

//    private String buildJson(List<Map<String, DataType<?>>> data){
//
//        JSONArray jsonArray = new JSONArray();
//
//        for (Map<String, DataType<?>> map : data) {
//            JSONObject json = new JSONObject();
//            for (String fieldName : map.keySet()) {
//                DataType<?> dataItem = map.get(fieldName);
//                if(dataItem == null){
//                    json.put(fieldName, JSONObject.NULL);
//                    continue;
//                }
//                json.put(fieldName, dataItem.getData());
//            }
//            jsonArray.put(json);
//        }
//
//        return jsonArray.toString();
//    }
//
//    private String buildCsv(List<Map<String, DataType<?>>> data){
//        List<String> fieldNames  = this.fields.keySet().stream().toList();
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (String fieldName : fieldNames) {
//            stringBuilder.append(fieldName);
//            stringBuilder.append(CSV_SEPARATOR);
//        }
//        stringBuilder.append("\n");
//
//        for (Map<String, DataType<?>> map : data) {
//            for (String fieldName : fieldNames) {
//                DataType<?> dataItem = map.get(fieldName);
//                if(dataItem == null){
//                    stringBuilder.append(CSV_SEPARATOR);
//                    continue;
//                }
//                stringBuilder.append(dataItem.getData());
//                stringBuilder.append(CSV_SEPARATOR);
//            }
//            stringBuilder.append("\n");
//        }
//
//        return stringBuilder.toString();
//    }

    public MockDataBuilder withValues(Map<String, List<String>> valuesMap) {
        this.valuesMap = valuesMap;
        return this;
    }
}
