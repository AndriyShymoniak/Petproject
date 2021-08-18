package com.shymoniak.search;

import com.shymoniak.entity.enums.SearchOperation;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SearchableFieldAnnotationProcessor<T> {

    // TODO: 2021-08-18 refactor
    public List<SearchCriteria> generateSearchCriteriaList(T t) {
        List<SearchCriteria> resultList = new ArrayList<>();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            SearchableFieldAnnotation annotation = field.getAnnotation(SearchableFieldAnnotation.class);
            if (annotation != null) {
                // Obtain field type
                Class<?> fieldType = field.getType();
                // Obtain field name
                String fieldName = field.getName();
                // Obtain field value
                Object value = getFieldValue(t, field.getName(), fieldType);
                // Obtain search operation
                SearchOperation searchOperation = annotation.operation();
                if (value != null) {
                    resultList.add(new SearchCriteria(fieldName, searchOperation, value.toString()));
                }
            }
        }
        return resultList;
    }

    private <T> T getFieldValue(Object object, String fieldName, Class<T> fieldType) {
        Field field = ReflectionUtils.findField(object.getClass(), fieldName, fieldType);
        ReflectionUtils.makeAccessible(field);
        return (T) ReflectionUtils.getField(field, object);
    }
}
