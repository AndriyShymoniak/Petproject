package com.shymoniak.service.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.model.PricePredictor;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.model.AccommodationFiller;
import com.shymoniak.service.AccommodationService;
import com.shymoniak.model.SearchUtility;
import com.shymoniak.utility.ObjectMapperUtils;
import com.shymoniak.search.entity.DynamicClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final ObjectMapperUtils mapper;
    private final SearchUtility<AccommodationDTO> searchUtility;
    private final AccommodationFiller accommodationFiller;
    private final PricePredictor<AccommodationDTO> pricePredictor;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    ObjectMapperUtils mapper,
                                    SearchUtility<AccommodationDTO> searchUtility,
                                    AccommodationFiller accommodationFiller,
                                    PricePredictor<AccommodationDTO> pricePredictor) {
        this.accommodationRepository = accommodationRepository;
        this.mapper = mapper;
        this.searchUtility = searchUtility;
        this.accommodationFiller = accommodationFiller;
        this.pricePredictor = pricePredictor;
    }

    @Override
    public AccommodationDTO addAccommodation(AccommodationDTO accommodation) {
        accommodation = accommodationFiller.fillMissingFields(accommodation);
        accommodationRepository.save(mapper.map(accommodation, AccommodationEntity.class));
        return accommodation;
    }

    @Override
    public AccommodationDTO findAccommodationById(Long id) {
        Optional<AccommodationEntity> optionalAccommodation = accommodationRepository.findById(id);
        if (optionalAccommodation.isPresent()) {
            return mapper.map(optionalAccommodation.get(), AccommodationDTO.class);
        } else {
            throw new ApiRequestException(ApplicationConstants.ERROR_MESSAGE_RECORD_NOT_FOUND);
        }
    }

    @Override
    public List<AccommodationDTO> findAllAccommodations() {
        List<AccommodationEntity> entityList = accommodationRepository.findAll();
        List<AccommodationDTO> dtoList = new ArrayList<>();
        for (AccommodationEntity accommodation : entityList) {
            dtoList.add(accommodationFiller.fillMissingFields(mapper.map(accommodation, AccommodationDTO.class)));
        }
        return dtoList;
    }

    @Override
    public List<AccommodationDTO> findBySearchCriteria(DynamicClass dynamicClass) {
        Specification specification = searchUtility.getDynamicSpecification(dynamicClass, new AccommodationDTO());
        return mapper.mapAll(accommodationRepository.findAll(specification), AccommodationDTO.class);
    }

    @Override
    public DynamicClass sendSearchConfig() {
        return searchUtility.generateDynamicClass(new AccommodationDTO());
    }

    @Override
    public AccommodationDTO deleteAccommodationById(Long id) {
        Optional<AccommodationEntity> optionalAccommodation = accommodationRepository.findById(id);
        if (optionalAccommodation.isPresent()) {
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

    @Override
    public Float predictAccommodationPrice(AccommodationDTO accommodation) {
        return pricePredictor.predict(accommodation, findAllAccommodations());
    }
}
