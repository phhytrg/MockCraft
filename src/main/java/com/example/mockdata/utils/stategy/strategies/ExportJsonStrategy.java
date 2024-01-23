package com.example.mockdata.utils.stategy.strategies;

import com.example.mockdata.domain.DataType;
import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;

import java.util.List;
import java.util.Map;

public class ExportJsonStrategy implements ExportStrategy {
    @Override
    public String export(List<Map<String, DataType<?>>> data) {
        JSONArray jsonArray = new JSONArray();

        for (Map<String, DataType<?>> map : data) {
            JSONObject json = new JSONObject();
            for (String fieldName : map.keySet()) {
                DataType<?> dataItem = map.get(fieldName);
                if (dataItem == null) {
                    json.put(fieldName, JSONObject.NULL);
                    continue;
                }
                json.put(fieldName, dataItem.getData());
            }
            jsonArray.put(json);
        }

        return jsonArray.toString();
    }
}
