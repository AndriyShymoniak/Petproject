package com.shymoniak.model.impl;

import com.shymoniak.annotation.SearchableFieldAnnotation;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.model.SearchUtility;
import com.shymoniak.utility.ObjectMapperUtils;
import com.shymoniak.search.SpecificationBuilder;
import com.shymoniak.search.entity.DynamicClass;
import com.shymoniak.search.entity.DynamicField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements search with dynamic amount of variables.
 * @param <T> - DTO class to be searched
 */
@Component
public class SearchUtilityImpl<T> implements SearchUtility<T> {

    private final SpecificationBuilder<T> specificationBuilder;
    private final ObjectMapperUtils objectMapperUtils;

    @Autowired
    public SearchUtilityImpl(SpecificationBuilder<T> specificationBuilder, ObjectMapperUtils objectMapperUtils) {
        this.specificationBuilder = specificationBuilder;
        this.objectMapperUtils = objectMapperUtils;
    }

    /**
     * Generates specification of searched object, based on its search
     * configuration.
     * @param dynamicClass - class with dynamically added search fields
     * @param t - instance of searched object
     * @return
     */
    @Override
    public Specification<T> getDynamicSpecification(DynamicClass dynamicClass, T t) {
        t = convertToOriginalClass(dynamicClass, t);
        return specificationBuilder.buildSpecification(t);
    }

    /**
     * Converts instance of searched class into DynamicClass
     * @param t - Class to be searched
     * @return
     */
    @Override
    public DynamicClass generateDynamicClass(T t) {
        List<DynamicField> dynamicFields = generateDynamicFields(t);
        return new DynamicClass(dynamicFields);
    }

    /**
     * Converts DynamicClass into its original class
     * @param dynamicClass
     * @param t
     * @return
     */
    @Override
    public T convertToOriginalClass(DynamicClass dynamicClass, T t) {
        try {
            List<DynamicField> dynamicFields = dynamicClass.getSourceClassFields();
            for (DynamicField dynamicField : dynamicFields) {
                String value = dynamicField.getValue();
                if (value != null && !value.isEmpty()) {
                    Field originalField = t.getClass().getDeclaredField(dynamicField.getFieldName());
                    Class<?> fieldType = originalField.getType();
                    originalField.setAccessible(true);
                    Object map = objectMapperUtils.map(value, fieldType);
                    originalField.set(t, map);
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiRequestException("Reflection exception occurred");
        }
    }

    /**
     * Generates dynamic fields of searched class
     * @param t
     * @return
     */
    private List<DynamicField> generateDynamicFields(T t) {
        List<DynamicField> dynamicFields = new ArrayList<>();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(SearchableFieldAnnotation.class)) {
                // Obtain field type
                Class<?> fieldType = field.getType();
                // Obtain field name
                String fieldName = field.getName();
                dynamicFields.add(new DynamicField(fieldType.toString(), fieldName));
            }
        }
        return dynamicFields;
    }
}
