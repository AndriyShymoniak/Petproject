package com.shymoniak.controller;

import com.shymoniak.domain.CityDTO;
import com.shymoniak.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<CityDTO>> showAllAccommodations() {
        return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDTO> addNewAccommodation(@RequestBody CityDTO city) {
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CityDTO> updatecity(@RequestBody CityDTO city) {
        return new ResponseEntity<>(cityService.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<CityDTO> deleteAccommodation(@RequestParam Long id) {
        return new ResponseEntity<>(cityService.deleteCityById(id), HttpStatus.OK);
    }
}
