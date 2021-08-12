package com.shymoniak.controller;

import com.shymoniak.domain.RoomDTO;
import com.shymoniak.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<RoomDTO>> showAllAccommodations() {
        return new ResponseEntity<>(roomService.findAllCities(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> addNewAccommodation(@RequestBody RoomDTO accommodation) {
        return new ResponseEntity<>(roomService.addRoom(accommodation), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RoomDTO> updateAccommodation(@RequestBody RoomDTO accommodation) {
        return new ResponseEntity<>(roomService.updateRoom(accommodation), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<RoomDTO> deleteAccommodation(@RequestParam Long id) {
        return new ResponseEntity<>(roomService.deleteRoomById(id), HttpStatus.OK);
    }
}
