package com.shymoniak.domain;

import com.shymoniak.entity.CityEntity;
import com.shymoniak.entity.LocationEntity;
import com.shymoniak.entity.RoomEntity;
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
    private List<RoomEntity> roomEntityList = new ArrayList<>();
    private LocationEntity locationEntity;
    private CityEntity cityEntity;
}
