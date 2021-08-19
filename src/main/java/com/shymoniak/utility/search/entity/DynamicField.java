package com.shymoniak.utility.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DynamicField {
    private String type;
    private String fieldName;
    private List<String> values;

    public DynamicField(String type, String fieldName) {
        this.type = type;
        this.fieldName = fieldName;
    }
}
