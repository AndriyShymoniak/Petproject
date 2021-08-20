package com.shymoniak.utility.search;

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
            SearchCriteria[] relatedCriteria = criteria.getRelatedCriteria();
            SearchCriteria from = relatedCriteria[0];
            SearchCriteria to = relatedCriteria[1];
            Predicate pred1 = builder.lessThanOrEqualTo(root.get(criteria.getKey()), to.getValue());
            Predicate pred2 = builder.greaterThanOrEqualTo(root.get(criteria.getKey()), from.getValue());
            return builder.and(pred1, pred2);
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
