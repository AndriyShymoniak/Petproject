package com.shymoniak.utility.search;

import com.shymoniak.utility.search.entity.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificationBuilder<T> {

    private SearchableFieldAnnotationProcessor<T> annotationProcessor;

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
