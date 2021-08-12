package com.shymoniak.service;

import com.shymoniak.domain.RoomDTO;

import java.util.List;

public interface RoomService {
    RoomDTO addRoom(RoomDTO roomDTO);

    RoomDTO findRoomById(Long id);

    List<RoomDTO> findAllCities();

    RoomDTO deleteRoomById(Long id);

    RoomDTO updateRoom(RoomDTO roomDTO);
}
