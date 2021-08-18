package com.shymoniak.search;

import com.shymoniak.entity.enums.SearchOperation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface SearchableFieldAnnotation {
    SearchOperation operation();
}
