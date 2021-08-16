package com.shymoniak.service.impl;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.service.AccommodationService;
import com.shymoniak.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private AccommodationRepository accommodationRepository;
    private ObjectMapperUtils mapper;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    ObjectMapperUtils mapper) {
        this.accommodationRepository = accommodationRepository;
        this.mapper = mapper;
    }

    @Override
    public AccommodationDTO addAccommodation(AccommodationDTO accommodation) {
        accommodationRepository.save(mapper.map(accommodation, AccommodationEntity.class));
        return accommodation;
    }

    @Override
    public AccommodationDTO findAccommodationById(Long id) {
        return mapper.map(accommodationRepository.findById(id).get(), AccommodationDTO.class);
    }

    @Override
    public List<AccommodationDTO> findAllAccommodations() {
        return mapper.mapAll(accommodationRepository.findAll(), AccommodationDTO.class);
    }

    @Override
    public AccommodationDTO deleteAccommodationById(Long id) {
        Optional<AccommodationEntity> optionalAccommodation = accommodationRepository.findById(id);
        accommodationRepository.deleteById(id);
        return mapper.map(optionalAccommodation.get(), AccommodationDTO.class);
    }

    @Override
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodation) {
        accommodationRepository.save(mapper.map(accommodation, AccommodationEntity.class));
        return accommodation;
    }

    private boolean isPresentInDB(Long id) {
        return accommodationRepository.findById(id) != null;
    }
}
