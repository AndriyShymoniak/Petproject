package com.shymoniak.entity;

import com.shymoniak.entity.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accommodation_id")
    private Long accommodationId;

    @Column(name = "price")
    private Long price;

    @Column(name = "description")
    private String description;

    @Column(name = "built_in")
    private LocalDate buildIn;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="room_id", referencedColumnName="accommodation_id")
    private List<Room> roomList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Accommodation(Long price, String description, LocalDate buildIn, Float squareMeterPrice, Float distanceToCityCenter, AccommodationClass accommodationClass, AccommodationCondition accommodationCondition, AccommodationType accommodationType) {
        this.price = price;
        this.description = description;
        this.buildIn = buildIn;
        this.squareMeterPrice = squareMeterPrice;
        this.distanceToCityCenter = distanceToCityCenter;
        this.accommodationClass = accommodationClass;
        this.accommodationCondition = accommodationCondition;
        this.accommodationType = accommodationType;
    }
}
