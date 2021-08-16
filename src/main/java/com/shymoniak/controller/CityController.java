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
    public ResponseEntity<List<CityDTO>> showAllCities() {
        return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<CityDTO> showCitiyById(@RequestParam Long id) {
        return new ResponseEntity<>(cityService.findCityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDTO> addNewCity(@RequestBody CityDTO city) {
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO city) {
        return new ResponseEntity<>(cityService.updateCity(city), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<CityDTO> deleteCity(@RequestParam Long id) {
        return new ResponseEntity<>(cityService.deleteCityById(id), HttpStatus.OK);
    }
}
