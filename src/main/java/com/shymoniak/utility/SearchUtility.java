package com.shymoniak.utility;

import com.shymoniak.annotation.SearchableFieldAnnotation;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.utility.search.SpecificationFormer;
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
public class SearchUtility<T> {

    private SpecificationFormer<T> specificationFormer;
    private ObjectMapperUtils objectMapperUtils;

    @Autowired
    public SearchUtility(SpecificationFormer<T> specificationFormer, ObjectMapperUtils objectMapperUtils) {
        this.specificationFormer = specificationFormer;
        this.objectMapperUtils = objectMapperUtils;
    }

    public Specification getDynamicSpecification(DynamicClass dynamicClass, T t){
        t = convertToOriginalClass(dynamicClass, t);
        return specificationFormer.formSpecification(t);
    }

    public DynamicClass generateDynamicClass(T t) {
        List<DynamicField> dynamicFields = generateDynamicFields(t);
        String fullClassPath = t.getClass().getCanonicalName();
        return new DynamicClass(fullClassPath, dynamicFields);
    }

    public T convertToOriginalClass(DynamicClass dynamicClass, T t) {
        try {
            List<DynamicField> dynamicFields = dynamicClass.getSourceClassFields();
            for (DynamicField dynamicField : dynamicFields) {
                Field originalField = t.getClass().getDeclaredField(dynamicField.getFieldName());
                Class<?> fieldType = originalField.getType();
                List<String> values = dynamicField.getValues();
                originalField.setAccessible(true);
                if (values != null && !values.isEmpty()) {
                    String value = values.get(0);
                    Object map = objectMapperUtils.map(value, fieldType);
                    originalField.set(t, map);
                }
            }
            return t;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new ApiRequestException("No such field");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new ApiRequestException("Illegal access");
        }
    }

    public static <T> T instanceOf(Class<T> clazz) throws Exception {
        return clazz.newInstance();
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

    private <T> T getFieldValue(Object object, String fieldName, Class<T> fieldType) {
        Field field = ReflectionUtils.findField(object.getClass(), fieldName, fieldType);
        ReflectionUtils.makeAccessible(field);
        return (T) ReflectionUtils.getField(field, object);
    }
}
