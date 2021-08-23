package com.shymoniak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name")
    private String cityName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_center_location")
    private LocationEntity centerLocation;

    @OneToMany(mappedBy = "city",
              fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              orphanRemoval = true)
    private List<AccommodationEntity> accommodationList;
}
