package com.shymoniak.utility.search;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.entity.enums.SearchOperation;
import com.shymoniak.utility.search.entity.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomSpecification<T> implements Specification<T> {
    private SearchCriteria criteria;

    public CustomSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation() == SearchOperation.GREATER_THAN) {
            return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.LESS_THAN) {
            return builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.BETWEEN) {
            String[] betweenValues = criteria.getValue().split(ApplicationConstants.SEARCH_BETWEEN_DELIMITER);
            return builder.between(root.get(criteria.getKey()), betweenValues[0], betweenValues[1]);
        } else if (criteria.getOperation() == SearchOperation.LIKE) {
            return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (criteria.getOperation() == SearchOperation.NOT_LIKE) {
            return builder.notLike(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (criteria.getOperation() == SearchOperation.EQUALS) {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.NOT_EQUALS) {
            return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
