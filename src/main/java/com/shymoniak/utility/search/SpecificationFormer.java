package com.shymoniak.utility.search;

import com.shymoniak.utility.search.entity.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SpecificationFormer<T> {

    private SearchableFieldAnnotationProcessor<T> annotationProcessor;

    @Autowired
    public SpecificationFormer(SearchableFieldAnnotationProcessor<T> annotationProcessor) {
        this.annotationProcessor = annotationProcessor;
    }

    /**
     * Forms Specification, based on objects configuration
     *
     * @param t - instance of searchable Class
     * @return
     */
    public Specification formSpecification(T t) {
        Map<String, List<CustomSpecification<T>>> specificationMap = generateSpecificationMap(t);
        CustomSpecification<T> customSpecification = null;
        for (String key : specificationMap.keySet()) {
            List<CustomSpecification<T>> sameKeySpecifications = specificationMap.get(key);
            if (customSpecification == null) {
                customSpecification = (disjunctSpecifications(sameKeySpecifications));
            } else {
                customSpecification.and(disjunctSpecifications(sameKeySpecifications));
            }
        }
        return Specification.where(customSpecification);
    }

    /**
     * If one field has multiple values on it - performs logical "OR" operation
     *
     * @param specificationList
     * @return
     */
    private CustomSpecification<T> disjunctSpecifications(List<CustomSpecification<T>> specificationList) {
        CustomSpecification<T> spec = null;
        for (CustomSpecification<T> customSpecification : specificationList) {
            if (spec == null) {
                spec = customSpecification;
            }
            spec.or(customSpecification);
        }
        return spec;
    }

    /**
     * This is a map, where specifications are sorted by search field name
     *
     * @param t - instance of searchable class
     * @return
     */
    private Map<String, List<CustomSpecification<T>>> generateSpecificationMap(T t) {
        List<SearchCriteria> criteriaList = annotationProcessor.generateSearchCriteriaList(t);
        Map<String, List<SearchCriteria>> criteriaMap = criteriaList.stream()
                .collect(Collectors.groupingBy(SearchCriteria::getKey));

        Map<String, List<CustomSpecification<T>>> result = new HashMap<>();
        for (String key : criteriaMap.keySet()) {
            List<CustomSpecification<T>> specificationList = new ArrayList<>();
            List<SearchCriteria> sameKeyCriteria = criteriaMap.get(key);
            for (SearchCriteria criteria : sameKeyCriteria) {
                specificationList.add(new CustomSpecification<>(criteria));
            }
            result.put(key, specificationList);
        }
        return result;
    }
}
