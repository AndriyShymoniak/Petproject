package com.shymoniak.model.impl;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.domain.LocationDTO;
import com.shymoniak.model.AccommodationFiller;
import com.shymoniak.model.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is used to add missing fields to accommodation.
 */
@Component
public class AccommodationFillerImpl implements AccommodationFiller {
    private final DistanceCalculator distanceCalculator;

    @Autowired
    public AccommodationFillerImpl(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public AccommodationDTO fillMissingFields(AccommodationDTO accommodation) {
        if (accommodation.getTotalArea() == null) {
            Float totalArea = accommodation.getRoomList().stream()
                    .map(room -> room.getSquare())
                    .reduce(0F, Float::sum);
            accommodation.setTotalArea(totalArea);
        }
        if (accommodation.getPrice() == null) {
            Float totalPrice = accommodation.getTotalArea() * accommodation.getSquareMeterPrice();
            accommodation.setPrice(totalPrice);
        }
        if (accommodation.getSquareMeterPrice() == null) {
            Float sqmPrice = accommodation.getPrice() / accommodation.getTotalArea();
            accommodation.setSquareMeterPrice(sqmPrice);
        }
        if (accommodation.getDistanceToCityCenter() == null) {
            LocationDTO accommodationLocation = accommodation.getLocation();
            LocationDTO cityCenterLocation = accommodation.getCity().getCenterLocation();
            Double distance = distanceCalculator.calculateDistance(accommodationLocation, cityCenterLocation);
            accommodation.setDistanceToCityCenter(distance.floatValue());
        }
        return accommodation;
    }
}
