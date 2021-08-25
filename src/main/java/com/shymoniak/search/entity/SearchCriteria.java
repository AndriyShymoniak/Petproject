package com.shymoniak.search.entity;

import com.shymoniak.entity.enums.SearchOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private String value;
    private SearchCriteria [] relatedCriteria;

    public SearchCriteria(String key, SearchOperation operation) {
        this.key = key;
        this.operation = operation;
    }

    public SearchCriteria(String key, SearchOperation operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCriteria(String key, SearchOperation operation, SearchCriteria[] relatedCriteria) {
        this.key = key;
        this.operation = operation;
        this.relatedCriteria = relatedCriteria;
    }
}
