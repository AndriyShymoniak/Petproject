package com.shymoniak.search;

import com.shymoniak.entity.enums.SearchOperation;
import com.shymoniak.annotation.SearchableFieldAnnotation;
import com.shymoniak.search.entity.SearchCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads DTO object and generates SearchCriteria based on configurations
 * @param <T> DTO class
 */
@Component
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
                // Not adding relation fields
                if ((value != null) && (!annotation.isRelation())) {
                    resultList.add(new SearchCriteria(fieldName, searchOperation, value.toString()));
                }
                if ((annotation.relatedFields().length != 0)) {
                    resultList.add(new SearchCriteria(fieldName, searchOperation, getChildrenElements(t, field)));
                }
            }
        }
        return resultList;
    }

    private SearchCriteria[] getChildrenElements(T t, Field fatherField) {
        List<SearchCriteria> result = new ArrayList<>();
        SearchableFieldAnnotation annotation = fatherField.getAnnotation(SearchableFieldAnnotation.class);
        String[] childrenNames = annotation.relatedFields();
        for (String child : childrenNames) {
            try {
                Field childField = t.getClass().getDeclaredField(child);
                Class<?> fieldType = childField.getType();
                String fieldName = childField.getName();
                Object value = getFieldValue(t, childField.getName(), fieldType);
                SearchOperation searchOperation = childField.getAnnotation(SearchableFieldAnnotation.class).operation();
                result.add(new SearchCriteria(fieldName, searchOperation, value.toString()));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return result.toArray(new SearchCriteria[result.size()]);
    }

    private <T> T getFieldValue(Object object, String fieldName, Class<T> fieldType) {
        Field field = ReflectionUtils.findField(object.getClass(), fieldName, fieldType);
        ReflectionUtils.makeAccessible(field);
        return (T) ReflectionUtils.getField(field, object);
    }
}
