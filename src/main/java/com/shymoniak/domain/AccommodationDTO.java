package com.shymoniak.domain;

import com.shymoniak.entity.City;
import com.shymoniak.entity.Location;
import com.shymoniak.entity.Room;
import com.shymoniak.entity.enums.AccommodationClass;
import com.shymoniak.entity.enums.AccommodationCondition;
import com.shymoniak.entity.enums.AccommodationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDTO {
    private Long accommodationId;
    private Long price;
    private String description;
    private LocalDate buildIn;
    private Float squareMeterPrice;
    private Float distanceToCityCenter;
    private AccommodationClass accommodationClass;
    private AccommodationCondition accommodationCondition;
    private AccommodationType accommodationType;
    private List<Room> roomList = new ArrayList<>();
    private Location location;
    private City city;
}
