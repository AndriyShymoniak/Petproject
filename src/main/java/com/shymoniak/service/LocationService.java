package com.shymoniak.service;

import com.shymoniak.domain.LocationDTO;

import java.util.List;

public interface LocationService {
    LocationDTO addLocation(LocationDTO locationDTO);

    LocationDTO findLocationById(Long id);

    List<LocationDTO> findAllCities();

    LocationDTO deleteLocationById(Long id);

    LocationDTO updateLocation(LocationDTO locationDTO);
}
