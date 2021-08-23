package com.shymoniak.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shymoniak.entity.enums.AccommodationClass;
import com.shymoniak.entity.enums.AccommodationCondition;
import com.shymoniak.entity.enums.AccommodationType;
import com.shymoniak.entity.enums.SearchOperation;
import com.shymoniak.annotation.SearchableFieldAnnotation;
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
    private String description;

    @SearchableFieldAnnotation(
            operation = SearchOperation.BETWEEN,
            relatedFields = {"priceFrom", "priceTo"}
    )
    private Float price;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private Float priceFrom;
    @SearchableFieldAnnotation(operation = SearchOperation.LESS_THAN, isRelation = true)
    private Float priceTo;

    @SearchableFieldAnnotation(operation = SearchOperation.EQUALS)
    private String currency;

//    @SearchableFieldAnnotation(operation = SearchOperation.BETWEEN)
    private LocalDate buildIn;

    @SearchableFieldAnnotation(operation = SearchOperation.BETWEEN)
    private Float totalArea;

    @SearchableFieldAnnotation(operation = SearchOperation.BETWEEN)
    private Float squareMeterPrice;

    @SearchableFieldAnnotation(operation = SearchOperation.BETWEEN)
    private Float distanceToCityCenter;

    private AccommodationClass accommodationClass;
    private AccommodationCondition accommodationCondition;
    private AccommodationType accommodationType;
    private CityDTO city;

    @JsonBackReference
    private LocationDTO location;
    private List<RoomDTO> roomList = new ArrayList<>();
    private List<MediaDTO> mediaList = new ArrayList<>();
}
