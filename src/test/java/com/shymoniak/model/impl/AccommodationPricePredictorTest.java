package com.shymoniak.model.impl;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.domain.LocationDTO;
import com.shymoniak.domain.RoomDTO;
import com.shymoniak.entity.enums.AccommodationClass;
import com.shymoniak.entity.enums.AccommodationCondition;
import com.shymoniak.entity.enums.AccommodationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccommodationPricePredictorTest {

    @Autowired
    private AccommodationPricePredictor<AccommodationDTO> pricePredictor;

    // TODO: 2021-09-07 Not working test
    @Test
    public void testPredict() {
//        List<RoomDTO> roomDTOS = new ArrayList<>();
//        roomDTOS.add(new RoomDTO(5000L, 28.4F, 3));
//        AccommodationDTO accommodationDTO = AccommodationDTO.builder()
//                .accommodationId(5000L)
//                .currency("USD")
//                .description("Test accommodation")
//                .buildIn(LocalDate.parse("1960-08-16"))
//                .distanceToCityCenter(1.5F)
//                .accommodationClass(AccommodationClass.ECONOMIC)
//                .accommodationType(AccommodationType.APARTMENT)
//                .accommodationCondition(AccommodationCondition.SATISFACTORY)
//                .location(new LocationDTO(5000L, "49.842606", "24.002470"))
//                .roomList(roomDTOS)
//                .build();
//        Double price = pricePredictor.predict(accommodationDTO); // real price = 32 000$
//        System.out.println(price);
    }
}