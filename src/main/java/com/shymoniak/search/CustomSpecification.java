package com.shymoniak.search;

import com.shymoniak.entity.enums.SearchOperation;
import com.shymoniak.search.entity.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomSpecification<T> implements Specification<T> {
    private final SearchCriteria criteria;

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
            return createBetweenPredicate(root, builder);
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

    private Predicate createBetweenPredicate(Root<T> root, CriteriaBuilder builder) {
        SearchCriteria child1 = criteria.getRelatedCriteria()[0];
        SearchCriteria child2 = criteria.getRelatedCriteria()[1];
        boolean hasValueChild1 = !child1.getValue().equals("");
        boolean hasValueChild2 = !child2.getValue().equals("");
        if (hasValueChild1 && hasValueChild2) {
            Predicate pred1 = createRelatedPredicate(criteria, child1, root, builder);
            Predicate pred2 = createRelatedPredicate(criteria, child2, root, builder);
            return builder.and(pred1, pred2);
        } else if (!hasValueChild1 && hasValueChild2){
            return createRelatedPredicate(criteria, child2, root, builder);
        } else if (!hasValueChild2 && hasValueChild1){
            return createRelatedPredicate(criteria, child1, root, builder);
        }
        return null;
    }

    private Predicate createRelatedPredicate(SearchCriteria parent,
                                             SearchCriteria child,
                                             Root<T> root,
                                             CriteriaBuilder builder) {
        if (child.getOperation() == SearchOperation.GREATER_THAN) {
            return builder.greaterThan(root.get(parent.getKey()), child.getValue());
        } else if (child.getOperation() == SearchOperation.LESS_THAN) {
            return builder.lessThan(root.get(parent.getKey()), child.getValue());
        } else if (criteria.getOperation() == SearchOperation.EQUALS) {
            return builder.equal(root.get(parent.getKey()), child.getValue());
        }
        return null;
    }
}
