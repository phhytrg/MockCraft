package com.example.mockdata.utils.stategy.context;

import com.example.mockdata.domain.DataType;
import com.example.mockdata.utils.stategy.strategies.ExportStrategy;

import java.util.List;
import java.util.Map;

public class ExportContext {
    private final ExportStrategy exportStrategy;

    public ExportContext(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public String export(List<Map<String, DataType<?>>> data) {
        return exportStrategy.export(data);
    }
}
