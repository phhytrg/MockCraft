package com.example.mockdata.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    static public String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    static public List<String> split(String str, String delimiter) {
        if(str == null || str.isEmpty()){
            return null;
        }
        return Arrays.asList(str.split(delimiter));
    }
}
