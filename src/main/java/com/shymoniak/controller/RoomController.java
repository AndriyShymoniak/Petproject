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
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<RoomDTO>> showAllRooms() {
        return new ResponseEntity<>(roomService.findAllCities(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<RoomDTO> showRoomById(@RequestParam Long id) {
        return new ResponseEntity<>(roomService.findRoomById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> addNewRoom(@RequestBody RoomDTO accommodation) {
        return new ResponseEntity<>(roomService.addRoom(accommodation), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO accommodation) {
        return new ResponseEntity<>(roomService.updateRoom(accommodation), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<RoomDTO> deleteRoom(@RequestParam Long id) {
        return new ResponseEntity<>(roomService.deleteRoomById(id), HttpStatus.OK);
    }
}
