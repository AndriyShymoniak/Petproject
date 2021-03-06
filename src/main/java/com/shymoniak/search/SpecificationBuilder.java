package com.shymoniak.search;

import com.shymoniak.search.entity.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Creates Specification for searched object
 * @param <T> DTO class
 */
@Component
public class SpecificationBuilder<T> {

    private final SearchableFieldAnnotationProcessor<T> annotationProcessor;

    @Autowired
    public SpecificationBuilder(SearchableFieldAnnotationProcessor<T> annotationProcessor) {
        this.annotationProcessor = annotationProcessor;
    }

    /**
     * Forms Specification, based on object's configuration
     *
     * @param t - instance of searchable Class
     * @return
     */
    public Specification buildSpecification(T t) {
        CustomSpecification<T> customSpecification = null;
        List<SearchCriteria> criteriaList = annotationProcessor.generateSearchCriteriaList(t);
        for (SearchCriteria criteria : criteriaList) {
            if(customSpecification == null){
                customSpecification = new CustomSpecification<>(criteria);
            }
            customSpecification.and(new CustomSpecification<>(criteria));
        }
        return Specification.where(customSpecification);
    }
}
