package com.shymoniak.domain;

import com.shymoniak.entity.LocationEntity;
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
public class CityDTO {
    private Long cityId;
    private String cityName;
    private List<LocationEntity> locationEntityList = new ArrayList<>();
}
