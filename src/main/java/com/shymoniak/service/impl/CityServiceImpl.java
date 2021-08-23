package com.shymoniak.service.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.domain.CityDTO;
import com.shymoniak.entity.CityEntity;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.repository.CityRepository;
import com.shymoniak.service.CityService;
import com.shymoniak.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ObjectMapperUtils mapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ObjectMapperUtils mapper) {
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public CityDTO addCity(CityDTO cityDTO) {
        cityRepository.save(mapper.map(cityDTO, CityEntity.class));
        return cityDTO;
    }

    @Override
    public CityDTO findCityById(Long id) {
        Optional<CityEntity> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            return mapper.map(optionalCity.get(), CityDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public List<CityDTO> findAllCities() {
        return mapper.mapAll(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO deleteCityById(Long id) {
        Optional<CityEntity> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            cityRepository.deleteById(id);
            return mapper.map(optionalCity.get(), CityDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public CityDTO updateCity(CityDTO cityDTO) {
        cityRepository.save(mapper.map(cityDTO, CityEntity.class));
        return cityDTO;
    }
}
