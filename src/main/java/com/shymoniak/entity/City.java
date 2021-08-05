package com.shymoniak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name")
    private String cityName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Location centerLocationId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    private List<Accommodation> accommodationList = new ArrayList<>();

    public City(String cityName, Location centerLocationId) {
        this.cityName = cityName;
        this.centerLocationId = centerLocationId;
    }
}
