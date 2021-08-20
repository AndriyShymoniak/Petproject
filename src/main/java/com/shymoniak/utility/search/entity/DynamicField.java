package com.shymoniak.utility.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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
