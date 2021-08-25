package com.shymoniak.model.impl;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.model.AccommodationFiller;
import org.springframework.stereotype.Component;

@Component
public class AccommodationFillerImpl implements AccommodationFiller {
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
        return accommodation;
    }

}
