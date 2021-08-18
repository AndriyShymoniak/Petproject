package com.shymoniak.utility;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.repository.AccommodationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class SearchUtilityTest {

    @Autowired
    private AccommodationRepository repository;
    SearchUtility<AccommodationDTO> searchUtility = new SearchUtility<>();

    @Test
    public void testSearch(){
        AccommodationDTO accommodationDTO = AccommodationDTO.builder()
                .currency("USD")
                .price(50000L)
                .build();

        Specification specification = searchUtility.formSpecification(accommodationDTO);
        List all = repository.findAll(specification);
        System.out.println(all);
    }
}