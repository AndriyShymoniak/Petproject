package com.shymoniak.search;

import com.shymoniak.entity.enums.SearchOperation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private String value;
}
