package com.shymoniak.service;

import com.shymoniak.domain.AccommodationDTO;

import java.util.List;

public interface AccommodationService {
    AccommodationDTO addAccommodation(AccommodationDTO accommodation);

    AccommodationDTO findAccommodationById(Long id);

    List<AccommodationDTO> findAllAccommodations();

    AccommodationDTO deleteAccommodationById(Long id);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodation);
}
