package com.shymoniak.service;

import com.shymoniak.domain.AccommodationDTO;

public interface AccommodationFiller {
    AccommodationDTO fillMissingFields(AccommodationDTO accommodation);
}
