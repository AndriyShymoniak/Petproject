package com.shymoniak.service.impl;

import com.shymoniak.domain.CityDTO;
import com.shymoniak.entity.CityEntity;
import com.shymoniak.repository.CityRepository;
import com.shymoniak.service.CityService;
import com.shymoniak.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private ObjectMapperUtils mapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ObjectMapperUtils mapper) {
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    //todo return object instead void
    @Override
    public CityDTO addCity(CityDTO cityDTO) {
        cityRepository.save(mapper.map(cityDTO, CityEntity.class));
        return cityDTO;
    }

    @Override
    public CityDTO findCityById(Long id) {
        return mapper.map(cityRepository.findById(id), CityDTO.class);
    }

    @Override
    public List<CityDTO> findAllCities() {
        return mapper.mapAll(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO deleteCityById(Long id) {
        Optional<CityEntity> optionalCity = cityRepository.findById(id);
        cityRepository.deleteById(id);
        return mapper.map(optionalCity.get(), CityDTO.class);
    }

    @Override
    public CityDTO updateCity(CityDTO cityDTO) {
        cityRepository.save(mapper.map(cityDTO, CityEntity.class));
        return cityDTO;
    }
}
