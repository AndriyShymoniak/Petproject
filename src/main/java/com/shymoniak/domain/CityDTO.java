package com.shymoniak.domain;

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
    private LocationDTO centerLocation;
}
