package com.shymoniak.service;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.utility.search.entity.DynamicClass;

import java.util.List;

public interface AccommodationService {
    AccommodationDTO addAccommodation(AccommodationDTO accommodation);

    AccommodationDTO findAccommodationById(Long id);

    List<AccommodationDTO> findAllAccommodations();

    List<AccommodationDTO> findBySearchCriteria(DynamicClass dynamicClass);

    DynamicClass sendSearchConfig();

    AccommodationDTO deleteAccommodationById(Long id);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodation);
}
