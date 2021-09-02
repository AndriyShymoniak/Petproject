package com.shymoniak.model;

import com.shymoniak.domain.LocationDTO;

public interface DistanceCalculator {
    Double calculateDistance(LocationDTO loc1, LocationDTO loc2);
}
