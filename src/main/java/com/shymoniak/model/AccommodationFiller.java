package com.shymoniak.model;

import com.shymoniak.domain.AccommodationDTO;

public interface AccommodationFiller {
    AccommodationDTO fillMissingFields(AccommodationDTO accommodation);
}
