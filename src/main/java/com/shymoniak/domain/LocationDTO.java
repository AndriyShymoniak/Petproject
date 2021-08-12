package com.shymoniak.domain;

import com.shymoniak.entity.AccommodationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private Long locationId;
    private String longitude;
    private String latitude;
    private List<AccommodationEntity> accommodationEntityList = new ArrayList<>();
}
