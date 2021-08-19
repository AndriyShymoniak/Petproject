package com.shymoniak.utility.search;

import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.entity.enums.SearchOperation;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.utility.search.entity.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class CustomSpecificationTest {
    @Autowired
    private AccommodationRepository repository;

    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        SearchCriteria criteria1 = new SearchCriteria("price", SearchOperation.GREATER_THAN, "50000");
        SearchCriteria criteria2 = new SearchCriteria("description", SearchOperation.LIKE, "house");
        CustomSpecification<AccommodationEntity> spec1 = new CustomSpecification<>(criteria1);
        CustomSpecification<AccommodationEntity> spec2 = new CustomSpecification<>(criteria2);

        List<AccommodationEntity> results = repository.findAll(Specification.where(spec1).and(spec2));
        System.out.println(results);
    }
}