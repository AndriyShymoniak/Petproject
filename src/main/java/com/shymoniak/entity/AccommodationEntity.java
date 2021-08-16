package com.shymoniak.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shymoniak.entity.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accommodation")
public class AccommodationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accommodation_id")
    private Long accommodationId;

    @Column(name = "price")
    private Long price;

    @Column(name = "currency", length = 3)
    private String currency;

    @Column(name = "description")
    private String description;

    @Column(name = "built_in")
    private LocalDate buildIn;

    @Column(name = "total_area")
    private Float totalArea;

    @Column(name = "square_meter_price")
    private Float squareMeterPrice;

    @Column(name = "distance_to_city_center")
    private Float distanceToCityCenter;

    @Column(name = "accommodation_class")
    @Enumerated(EnumType.STRING)
    private AccommodationClass accommodationClass;

    @Column(name = "accommodation_condition")
    @Enumerated(EnumType.STRING)
    private AccommodationCondition accommodationCondition;

    @Column(name = "accommodation_type")
    @Enumerated(EnumType.STRING)
    private AccommodationType accommodationType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private LocationEntity locationEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id")
    private List<RoomEntity> roomEntityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id")
    private List<MediaEntity> mediaEntityList = new ArrayList<>();
}
