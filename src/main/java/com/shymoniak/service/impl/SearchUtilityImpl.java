package com.shymoniak.service.impl;

import com.shymoniak.annotation.SearchableFieldAnnotation;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.service.SearchUtility;
import com.shymoniak.utility.ObjectMapperUtils;
import com.shymoniak.utility.search.SpecificationBuilder;
import com.shymoniak.utility.search.entity.DynamicClass;
import com.shymoniak.utility.search.entity.DynamicField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchUtilityImpl<T> implements SearchUtility<T> {

    private SpecificationBuilder<T> specificationBuilder;
    private ObjectMapperUtils objectMapperUtils;

    @Autowired
    public SearchUtilityImpl(SpecificationBuilder<T> specificationBuilder, ObjectMapperUtils objectMapperUtils) {
        this.specificationBuilder = specificationBuilder;
        this.objectMapperUtils = objectMapperUtils;
    }

    @Override
    public Specification getDynamicSpecification(DynamicClass dynamicClass, T t) {
        t = convertToOriginalClass(dynamicClass, t);
        return specificationBuilder.buildSpecification(t);
    }

    @Override
    public DynamicClass generateDynamicClass(T t) {
        List<DynamicField> dynamicFields = generateDynamicFields(t);
        String fullClassPath = t.getClass().getCanonicalName();
        return new DynamicClass(fullClassPath, dynamicFields);
    }

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