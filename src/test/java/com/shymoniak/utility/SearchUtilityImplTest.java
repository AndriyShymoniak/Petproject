package com.shymoniak.utility;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.service.impl.SearchUtilityImpl;
import com.shymoniak.utility.search.SpecificationBuilder;
import com.shymoniak.utility.search.entity.DynamicClass;
import com.shymoniak.utility.search.entity.DynamicField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class SearchUtilityImplTest {

    @Autowired
    private AccommodationRepository repository;

    @Autowired
    SearchUtilityImpl<AccommodationDTO> searchUtility;

    @Autowired
    SpecificationBuilder<AccommodationDTO> specificationBuilder;

    @Test
    public void testSearch() {
        AccommodationDTO accommodationDTO = AccommodationDTO.builder()
                .currency("USD")
                .price(50000F)
                .build();

        Specification specification = specificationBuilder.buildSpecification(accommodationDTO);
        List all = repository.findAll(specification);
        System.out.println(all);
    }

    @Test
    public void generateDynamicClassTest() {
        DynamicClass dynamicClass = searchUtility.generateDynamicClass(new AccommodationDTO());
        System.out.println(dynamicClass);
    }

    @Test
    public void convertToOriginalClassTest() {
        List<String> values = Stream.of("50000").collect(Collectors.toList());
        AccommodationDTO accommodationDTO = new AccommodationDTO();
        DynamicClass dyn = searchUtility.generateDynamicClass(accommodationDTO);
        List<DynamicField> sourceClassFields = dyn.getSourceClassFields();
        DynamicField dynamicField = sourceClassFields.get(0);
        dynamicField.setValue(values.get(0));
        DynamicClass dynamicClass = new DynamicClass(dyn.getSourceClassFields());
        AccommodationDTO result = searchUtility.convertToOriginalClass(dynamicClass, new AccommodationDTO());
        System.out.println(result);

        Specification specification = specificationBuilder.buildSpecification(result);
        List all = repository.findAll(specification);
        System.out.println(all);
    }
}