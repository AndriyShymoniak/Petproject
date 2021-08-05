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
        Room room1 = new Room(64, 2);
        Room room2 = new Room(29, 8);
        Room room3 = new Room(110, 10);
        Room room4 = new Room(50, 4);
        Room room5 = new Room(100, 5);
        Room room6 = new Room(30, 4);
        rooms.addAll(Stream.of(room1, room2, room3, room4, room5, room6)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateLocationList() {
        Location location1 = new Location("49.6415", "30.7954");
        Location location2 = new Location("47.4520", "35.5554");
        Location location3 = new Location("46.5116", "40.4468");
        Location location4 = new Location("45.7845", "39.8745");
        Location location5 = new Location("42.1986", "40.7877");
        Location location6 = new Location("49.5555", "37.4747");
        Location location7 = new Location("45.7787", "50.8745");
        locations.addAll(Stream.of(location1, location2, location3, location4, location5, location6, location7)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateCityList() {
        City city1 = new City("Lviv", locations.get(0));
        City city2 = new City("Kyiv", locations.get(1));
        City city3 = new City("Odessa", locations.get(2));
        cities.addAll(Stream.of(city1, city2, city3)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private void generateAccommodationList() {
        Accommodation accommodation1 = new Accommodation(50000L, "description1 example", LocalDate.now(), 50.3f, 5.3f, AccommodationClass.COMFORT, AccommodationCondition.GOOD, AccommodationType.APARTMENT);
        Accommodation accommodation2 = new Accommodation(60000L, "description2 example", LocalDate.now(), 70.3f, 6.3f, AccommodationClass.ELITE, AccommodationCondition.PERFECT, AccommodationType.HOUSE);
        Accommodation accommodation3 = new Accommodation(70000L, "description3 example", LocalDate.now(), 90.3f, 7.3f, AccommodationClass.BUSINESS, AccommodationCondition.SATISFACTORY, AccommodationType.OFFICE);

        accommodation1.setLocation(locations.get(3));
        accommodation1.getRoomList().add(rooms.get(0));

        accommodation2.setLocation(locations.get(4));
        accommodation2.getRoomList().add(rooms.get(1));

        accommodation3.setLocation(locations.get(5));
        accommodation3.getRoomList().add(rooms.get(2));
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
