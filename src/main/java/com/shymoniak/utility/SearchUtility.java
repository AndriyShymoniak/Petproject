package com.shymoniak.utility;

import com.shymoniak.search.CustomSpecification;
import com.shymoniak.search.SearchCriteria;
import com.shymoniak.search.SearchableFieldAnnotationProcessor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchUtility<T> {

    private SearchableFieldAnnotationProcessor<T> annotationProcessor = new SearchableFieldAnnotationProcessor<>();

    // TODO: 2021-08-18 refactor
    public Specification formSpecification(T t) {
        CustomSpecification<T> customSpecification = null;
        Map<String, List<CustomSpecification<T>>> specificationMap = generateSpecificationMap(t);

        for (String key : specificationMap.keySet()) {
            List<CustomSpecification<T>> sameKeySpecifications = specificationMap.get(key);
            if (customSpecification == null){
                customSpecification = (disjunctSpecifications(sameKeySpecifications));
            } else {
                customSpecification.and(disjunctSpecifications(sameKeySpecifications));
            }
        }
        return Specification.where(customSpecification);
    }

    // TODO: 2021-08-18 refactor
    private CustomSpecification<T> disjunctSpecifications(List<CustomSpecification<T>> specificationList) {
        CustomSpecification<T> spec = specificationList.get(0);
        for (CustomSpecification<T> customSpecification : specificationList) {
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
