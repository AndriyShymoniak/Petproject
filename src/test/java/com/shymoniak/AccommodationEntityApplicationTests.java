package com.shymoniak;

import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.entity.CityEntity;
import com.shymoniak.entity.LocationEntity;
import com.shymoniak.entity.RoomEntity;
import com.shymoniak.entity.enums.AccommodationClass;
import com.shymoniak.entity.enums.AccommodationCondition;
import com.shymoniak.entity.enums.AccommodationType;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.repository.CityRepository;
import com.shymoniak.repository.LocationRepository;
import com.shymoniak.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccommodationEntityApplicationTests {
    private final List<RoomEntity> roomEntities = new ArrayList<>();
    private final List<LocationEntity> locationEntities = new ArrayList<>();
    private final List<CityEntity> cities = new ArrayList<>();
    private final List<AccommodationEntity> accommodationEntities = new ArrayList<>();

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LocationRepository locationRepository;

//    @BeforeEach
    public void createInitialDbRecords() {
        generateRoomList();
        generateLocationList();
        generateCityList();
        generateAccommodationList();
    }

    private void generateRoomList() {
        RoomEntity roomEntity1 = RoomEntity.builder().square(64F).floor(2).build();
        RoomEntity roomEntity2 = RoomEntity.builder().square(29F).floor(8).build();
        RoomEntity roomEntity3 = RoomEntity.builder().square(11F).floor(10).build();
        RoomEntity roomEntity4 = RoomEntity.builder().square(50F).floor(4).build();
        RoomEntity roomEntity5 = RoomEntity.builder().square(10F).floor(5).build();
        RoomEntity roomEntity6 = RoomEntity.builder().square(30F).floor(4).build();
        roomEntities.addAll(Stream.of(roomEntity1, roomEntity2, roomEntity3, roomEntity4, roomEntity5, roomEntity6)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateLocationList() {
        LocationEntity locationEntity1 = LocationEntity.builder().longitude("49.6415").latitude("30.7954").build();
        LocationEntity locationEntity2 = LocationEntity.builder().longitude("47.4520").latitude("35.5554").build();
        LocationEntity locationEntity3 = LocationEntity.builder().longitude("46.5116").latitude("40.4468").build();
        LocationEntity locationEntity4 = LocationEntity.builder().longitude("45.7845").latitude("39.8745").build();
        LocationEntity locationEntity5 = LocationEntity.builder().longitude("42.1986").latitude("40.7877").build();
        LocationEntity locationEntity6 = LocationEntity.builder().longitude("49.5555").latitude("37.4747").build();
        LocationEntity locationEntity7 = LocationEntity.builder().longitude("45.7787").latitude("50.8745").build();
        locationEntities.addAll(Stream.of(locationEntity1, locationEntity2, locationEntity3, locationEntity4, locationEntity5, locationEntity6, locationEntity7)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateCityList() {
        CityEntity cityEntity1 = CityEntity.builder()
                .cityName("Lviv")
                .centerLocation(locationEntities.get(0))
                .build();
        CityEntity cityEntity2 = CityEntity.builder()
                .cityName("Kyiv")
                .centerLocation(locationEntities.get(2))
                .build();
        CityEntity cityEntity3 = CityEntity.builder()
                .cityName("Odessa")
                .centerLocation(locationEntities.get(4))
                .build();

        cities.addAll(Stream.of(cityEntity1, cityEntity2, cityEntity3)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateAccommodationList() {
        AccommodationEntity accommodationEntity1 = AccommodationEntity.builder()
                .price(50000F)
                .description("Lovely family house...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(9.1F)
                .accommodationClass(AccommodationClass.COMFORT)
                .accommodationCondition(AccommodationCondition.GOOD)
                .accommodationType(AccommodationType.HOUSE)
                .location(locationEntities.get(3))
                .roomList(Arrays.asList(roomEntities.get(0), roomEntities.get(1)))
                .city(cities.get(0))
                .build();

        AccommodationEntity accommodationEntity2 = AccommodationEntity.builder()
                .price(60000F)
                .description("Decent office for your business...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(3.3F)
                .accommodationClass(AccommodationClass.BUSINESS)
                .accommodationCondition(AccommodationCondition.SATISFACTORY)
                .accommodationType(AccommodationType.OFFICE)
                .location(locationEntities.get(4))
                .roomList(Arrays.asList(roomEntities.get(2), roomEntities.get(3)))
                .city(cities.get(1))
                .build();

        AccommodationEntity accommodationEntity3 = AccommodationEntity.builder()
                .price(70000F)
                .description("Luxurious apartment...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(2.7F)
                .accommodationClass(AccommodationClass.ELITE)
                .accommodationCondition(AccommodationCondition.PERFECT)
                .accommodationType(AccommodationType.APARTMENT)
                .location(locationEntities.get(5))
                .roomList(Arrays.asList(roomEntities.get(4), roomEntities.get(5)))
                .city(cities.get(2))
                .build();

        AccommodationEntity accommodationEntity4 = AccommodationEntity.builder()
                .price(80000F)
                .description("Luxurious apartment...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(2.7F)
                .accommodationClass(AccommodationClass.ELITE)
                .accommodationCondition(AccommodationCondition.PERFECT)
                .accommodationType(AccommodationType.APARTMENT)
                .location(locationEntities.get(5))
                .roomList(Arrays.asList(roomEntities.get(4), roomEntities.get(5)))
                .city(cities.get(2))
                .build();
        accommodationEntities.addAll(Stream.of(accommodationEntity1, accommodationEntity2, accommodationEntity3, accommodationEntity4)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    @Test
    public void locationRepositoryTest() {
        createInitialDbRecords();
        locationRepository.saveAll(locationEntities);
        List<LocationEntity> receivedLocationEntities = locationRepository.findAll();
        assertFalse(CollectionUtils.isEmpty(receivedLocationEntities));
    }

    @Test
    public void cityRepositoryTest() {
        createInitialDbRecords();
        cityRepository.saveAll(cities);
        List<CityEntity> receivedCities = cityRepository.findAll();
        assertFalse(CollectionUtils.isEmpty(receivedCities));
    }

    @Test
    public void roomRepositoryTest() {
        createInitialDbRecords();
        roomRepository.saveAll(roomEntities);
        List<RoomEntity> receivedRoomEntities = roomRepository.findAll();
        assertFalse(CollectionUtils.isEmpty(receivedRoomEntities));

    }

    @Test
    public void accommodationRepositoryTest() {
        createInitialDbRecords();
        accommodationRepository.saveAll(accommodationEntities);
        List<AccommodationEntity> receivedAccommodationEntities = accommodationRepository.findAll();
        assertFalse(CollectionUtils.isEmpty(receivedAccommodationEntities));
    }
}
