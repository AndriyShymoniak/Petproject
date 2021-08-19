package com.shymoniak.annotation;

import com.shymoniak.entity.enums.SearchOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SearchableFieldAnnotation {
    SearchOperation operation();
}
