package com.shymoniak.service;

import com.shymoniak.domain.CityDTO;

import java.util.List;

public interface CityService {
    CityDTO addCity(CityDTO cityDTO);

    CityDTO findCityById(Long id);

    List<CityDTO> findAllCities();

    CityDTO deleteCityById(Long id);

    CityDTO updateCity(CityDTO cityDTO);
}
