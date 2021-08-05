package com.shymoniak;

import com.shymoniak.entity.Accommodation;
import com.shymoniak.entity.City;
import com.shymoniak.entity.Location;
import com.shymoniak.entity.Room;
import com.shymoniak.entity.enums.AccommodationClass;
import com.shymoniak.entity.enums.AccommodationCondition;
import com.shymoniak.entity.enums.AccommodationType;
import com.shymoniak.repository.AccommodationRepository;
import com.shymoniak.repository.CityRepository;
import com.shymoniak.repository.LocationRepository;
import com.shymoniak.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccommodationApplicationTests {
    private List<Room> rooms = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<City> cities = new ArrayList<>();
    private List<Accommodation> accommodations = new ArrayList<>();

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LocationRepository locationRepository;

    @BeforeEach
    public void createInitialDbRecords() {
        generateRoomList();
        generateLocationList();
        generateCityList();
        generateAccommodationList();
    }

    private void generateRoomList() {
        Room room1 = Room.builder().square(64).floor(2).build();
        Room room2 = Room.builder().square(29).floor(8).build();
        Room room3 = Room.builder().square(11).floor(10).build();
        Room room4 = Room.builder().square(50).floor(4).build();
        Room room5 = Room.builder().square(10).floor(5).build();
        Room room6 = Room.builder().square(30).floor(4).build();
        rooms.addAll(Stream.of(room1, room2, room3, room4, room5, room6)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateLocationList() {
        Location location1 = Location.builder().longitude("49.6415").latitude("30.7954").build();
        Location location2 = Location.builder().longitude("47.4520").latitude("35.5554").build();
        Location location3 = Location.builder().longitude("46.5116").latitude("40.4468").build();
        Location location4 = Location.builder().longitude("45.7845").latitude("39.8745").build();
        Location location5 = Location.builder().longitude("42.1986").latitude("40.7877").build();
        Location location6 = Location.builder().longitude("49.5555").latitude("37.4747").build();
        Location location7 = Location.builder().longitude("45.7787").latitude("50.8745").build();
        locations.addAll(Stream.of(location1, location2, location3, location4, location5, location6, location7)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateCityList() {
        City city1 = City.builder()
                .cityName("Lviv")
                .locationList(Arrays.asList(locations.get(0), locations.get(1)))
                .build();
        City city2 = City.builder()
                .cityName("Kyiv")
                .locationList(Arrays.asList(locations.get(2), locations.get(3)))
                .build();
        City city3 = City.builder()
                .cityName("Odessa")
                .locationList(Arrays.asList(locations.get(4), locations.get(5)))
                .build();

        cities.addAll(Stream.of(city1, city2, city3)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateAccommodationList() {
        Accommodation accommodation1 = Accommodation.builder()
                .price(50000L)
                .description("Lovely family house...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(9.1F)
                .accommodationClass(AccommodationClass.COMFORT)
                .accommodationCondition(AccommodationCondition.GOOD)
                .accommodationType(AccommodationType.HOUSE)
                .location(locations.get(3))
                .roomList(Arrays.asList(rooms.get(0), rooms.get(1)))
                .city(cities.get(0))
                .build();

        Accommodation accommodation2 = Accommodation.builder()
                .price(60000L)
                .description("Decent office for your business...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(3.3F)
                .accommodationClass(AccommodationClass.BUSINESS)
                .accommodationCondition(AccommodationCondition.SATISFACTORY)
                .accommodationType(AccommodationType.OFFICE)
                .location(locations.get(4))
                .roomList(Arrays.asList(rooms.get(2), rooms.get(3)))
                .city(cities.get(1))
                .build();

        Accommodation accommodation3 = Accommodation.builder()
                .price(70000L)
                .description("Luxurious apartment...")
                .buildIn(LocalDate.now())
                .squareMeterPrice(50.7F)
                .distanceToCityCenter(2.7F)
                .accommodationClass(AccommodationClass.ELITE)
                .accommodationCondition(AccommodationCondition.PERFECT)
                .accommodationType(AccommodationType.APARTMENT)
                .location(locations.get(5))
                .roomList(Arrays.asList(rooms.get(4), rooms.get(5)))
                .city(cities.get(2))
                .build();

        accommodations.addAll(Stream.of(accommodation1, accommodation2, accommodation3)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    @Test
    public void locationRepositoryTest() {
        locationRepository.saveAll(locations);
    }

    @Test
    public void cityRepositoryTest() {
        cityRepository.saveAll(cities);
    }

    @Test
    public void roomRepositoryTest() {
        roomRepository.saveAll(rooms);
    }

    @Test
    public void accommodationRepositoryTest() {
        accommodationRepository.saveAll(accommodations);
    }
}
