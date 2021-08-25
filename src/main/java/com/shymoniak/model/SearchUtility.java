package com.shymoniak.model;

import com.shymoniak.search.entity.DynamicClass;
import org.springframework.data.jpa.domain.Specification;

public interface SearchUtility<T> {
    Specification<T> getDynamicSpecification(DynamicClass dynamicClass, T t);

     DynamicClass generateDynamicClass(T t);

    T convertToOriginalClass(DynamicClass dynamicClass, T t);
}
