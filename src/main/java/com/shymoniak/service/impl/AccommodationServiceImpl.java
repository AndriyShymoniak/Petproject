package com.shymoniak.service.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.service.AccommodationService;
import com.shymoniak.utility.ObjectMapperUtils;
import com.shymoniak.utility.SearchUtility;
import com.shymoniak.utility.search.entity.DynamicClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final ObjectMapperUtils mapper;
    private final SearchUtility<AccommodationDTO> searchUtility;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    ObjectMapperUtils mapper,
                                    SearchUtility<AccommodationDTO> searchUtility) {
        this.accommodationRepository = accommodationRepository;
        this.mapper = mapper;
        this.searchUtility = searchUtility;
    }

    @Override
    public AccommodationDTO addAccommodation(AccommodationDTO accommodation) {
        accommodationRepository.save(mapper.map(accommodation, AccommodationEntity.class));
        return accommodation;
    }

    @Override
    public AccommodationDTO findAccommodationById(Long id) {
        Optional<AccommodationEntity> optionalAccommodation = accommodationRepository.findById(id);
        if (optionalAccommodation.isPresent()){
            return mapper.map(optionalAccommodation.get(), AccommodationDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public List<AccommodationDTO> findAllAccommodations() {
        return mapper.mapAll(accommodationRepository.findAll(), AccommodationDTO.class);
    }

    @Override
    public List<AccommodationDTO> findBySearchCriteria() {
        return null;
    }

    @Override
    public DynamicClass sendSearchConfig() {
        return searchUtility.generateDynamicClass(new AccommodationDTO());
    }

    @Override
    public AccommodationDTO deleteAccommodationById(Long id) {
        Optional<AccommodationEntity> optionalAccommodation = accommodationRepository.findById(id);
        if (optionalAccommodation.isPresent()){
            accommodationRepository.deleteById(id);
            return mapper.map(optionalAccommodation.get(), AccommodationDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodation) {
        accommodationRepository.save(mapper.map(accommodation, AccommodationEntity.class));
        return accommodation;
    }
}
