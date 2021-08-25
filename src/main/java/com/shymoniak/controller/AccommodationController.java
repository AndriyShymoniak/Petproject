package com.shymoniak.controller;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.service.AccommodationService;
import com.shymoniak.search.entity.DynamicClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<AccommodationDTO>> showAllAccommodations() {
        return new ResponseEntity<>(accommodationService.findAllAccommodations(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<AccommodationDTO> showAccommodationById(@RequestParam Long id) {
        return new ResponseEntity<>(accommodationService.findAccommodationById(id), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<AccommodationDTO>> showFilteredAccommodations(@RequestBody DynamicClass dynamicClass) {
        return new ResponseEntity<>(accommodationService.findBySearchCriteria(dynamicClass), HttpStatus.OK);
    }

    @GetMapping("/searchConfig")
    public ResponseEntity<DynamicClass> getSearchConfig() {
        return new ResponseEntity<>(accommodationService.sendSearchConfig(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccommodationDTO> addNewAccommodation(@RequestBody AccommodationDTO accommodation) {
        return new ResponseEntity<>(accommodationService.addAccommodation(accommodation), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccommodationDTO> updateAccommodation(@RequestBody AccommodationDTO accommodation) {
        return new ResponseEntity<>(accommodationService.updateAccommodation(accommodation), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<AccommodationDTO> deleteAccommodation(@RequestParam Long id) {
        return new ResponseEntity<>(accommodationService.deleteAccommodationById(id), HttpStatus.OK);
    }
}
