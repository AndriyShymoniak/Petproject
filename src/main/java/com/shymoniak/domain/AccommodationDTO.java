package com.shymoniak.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shymoniak.entity.CityEntity;
import com.shymoniak.entity.LocationEntity;
import com.shymoniak.entity.MediaEntity;
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
    private String currency;
    private String description;
    private LocalDate buildIn;
    private Float totalArea;
    private Float squareMeterPrice;
    private Float distanceToCityCenter;
    private AccommodationClass accommodationClass;
    private AccommodationCondition accommodationCondition;
    private AccommodationType accommodationType;

    @JsonBackReference
    private LocationDTO locationEntity;
    private CityDTO cityEntity;
    private List<RoomDTO> roomEntityList = new ArrayList<>();
    private List<MediaDTO> mediaEntityList = new ArrayList<>();
}
