package com.shymoniak.model;

import com.shymoniak.domain.AccommodationDTO;

// TODO: 2021-08-27 Remove and make a front task

/**
 * Is used to fill additional fields in Accommodation
 */
public interface AccommodationFiller {
    AccommodationDTO fillMissingFields(AccommodationDTO accommodation);
}
