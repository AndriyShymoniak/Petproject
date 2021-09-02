package com.shymoniak.annotation;

import com.shymoniak.entity.enums.SearchOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is put over DTO's fields, which are meant to be used in
 * dynamic search in database.
 * <br><b>operation</b> - required parameter which is used to define logical operation of
 * field to search. (example: >, <, =, in, between, etc.).
 * <br><b>related fields</b> - artificially created fields in DTO, which are used in
 * "between" and "in" operations.
 * <br><b>isRelation</b> - field is used to mark artificially created relation fields.
 */
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SearchableFieldAnnotation {
    SearchOperation operation();

    String[] relatedFields() default {};

    boolean isRelation() default false;
}
