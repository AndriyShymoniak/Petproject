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
    public ResponseEntity<List<LocationDTO>> showAllAccommodations() {
        return new ResponseEntity<>(locationService.findAllCities(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> addNewAccommodation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.addLocation(locationDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LocationDTO> updateAccommodation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.updateLocation(locationDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<LocationDTO> deleteAccommodation(@RequestParam Long id) {
        return new ResponseEntity<>(locationService.deleteLocationById(id), HttpStatus.OK);
    }
}
