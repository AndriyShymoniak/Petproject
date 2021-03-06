package com.shymoniak.service.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.domain.LocationDTO;
import com.shymoniak.entity.LocationEntity;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.repository.LocationRepository;
import com.shymoniak.service.LocationService;
import com.shymoniak.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ObjectMapperUtils mapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, ObjectMapperUtils mapper) {
        this.locationRepository = locationRepository;
        this.mapper = mapper;
    }

    @Override
    public LocationDTO addLocation(LocationDTO locationDTO) {
        locationRepository.save(mapper.map(locationDTO, LocationEntity.class));
        return locationDTO;
    }

    @Override
    public LocationDTO findLocationById(Long id) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isPresent()){
            return mapper.map(optionalLocation.get(), LocationDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public List<LocationDTO> findAllCities() {
        return mapper.mapAll(locationRepository.findAll(), LocationDTO.class);
    }

    @Override
    public LocationDTO deleteLocationById(Long id) {
        Optional<LocationEntity> optionalLocation = locationRepository.findById(id);
        locationRepository.deleteById(id);
        return mapper.map(optionalLocation.get(), LocationDTO.class);
    }

    @Override
    public LocationDTO updateLocation(LocationDTO locationDTO) {
        locationRepository.save(mapper.map(locationDTO, LocationEntity.class));
        return locationDTO;
    }
}
