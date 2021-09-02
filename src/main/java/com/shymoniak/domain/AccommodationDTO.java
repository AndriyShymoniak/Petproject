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

    @SearchableFieldAnnotation(
            operation = SearchOperation.BETWEEN,
            relatedFields = {"buildInFrom", "buildInTo"}
    )
    private LocalDate buildIn;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate buildInFrom;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate buildInTo;

    @SearchableFieldAnnotation(
            operation = SearchOperation.BETWEEN,
            relatedFields = {"totalAreaFrom", "totalAreaTo"}
    )
    private Float totalArea;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate totalAreaFrom;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate totalAreaTo;

    @SearchableFieldAnnotation(
            operation = SearchOperation.BETWEEN,
            relatedFields = {"squareMeterPriceFrom", "squareMeterPriceTo"}
    )
    private Float squareMeterPrice;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate squareMeterPriceFrom;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate squareMeterPriceTo;

    @SearchableFieldAnnotation(
            operation = SearchOperation.BETWEEN,
            relatedFields = {"distanceToCityCenterFrom", "distanceToCityCenterTo"}
    )
    private Float distanceToCityCenter;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate distanceToCityCenterFrom;
    @SearchableFieldAnnotation(operation = SearchOperation.GREATER_THAN, isRelation = true)
    private LocalDate distanceToCityCenterTo;

    private AccommodationClass accommodationClass;
    private AccommodationCondition accommodationCondition;
    private AccommodationType accommodationType;
    private CityDTO city;

    private LocationDTO location;
    private List<RoomDTO> roomList = new ArrayList<>();
    private List<MediaDTO> mediaList = new ArrayList<>();
}
