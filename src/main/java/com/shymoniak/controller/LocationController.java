package com.shymoniak.controller;

import com.shymoniak.domain.LocationDTO;
import com.shymoniak.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<LocationDTO>> showAllLocations() {
        return new ResponseEntity<>(locationService.findAllCities(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<LocationDTO> showALocationById(@RequestParam Long id) {
        return new ResponseEntity<>(locationService.findLocationById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> addNewLocation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.addLocation(locationDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LocationDTO> updateLocation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.updateLocation(locationDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<LocationDTO> deleteLocation(@RequestParam Long id) {
        return new ResponseEntity<>(locationService.deleteLocationById(id), HttpStatus.OK);
    }
}
