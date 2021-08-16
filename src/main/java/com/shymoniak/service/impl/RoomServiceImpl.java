package com.shymoniak.service.impl;

import com.shymoniak.domain.RoomDTO;
import com.shymoniak.entity.RoomEntity;
import com.shymoniak.repository.RoomRepository;
import com.shymoniak.service.RoomService;
import com.shymoniak.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private ObjectMapperUtils mapper;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, ObjectMapperUtils mapper) {
        this.roomRepository = roomRepository;
        this.mapper = mapper;
    }

    @Override
    public RoomDTO addRoom(RoomDTO roomDTO) {
        roomRepository.save(mapper.map(roomDTO, RoomEntity.class));
        return roomDTO;
    }

    @Override
    public RoomDTO findRoomById(Long id) {
        return mapper.map(roomRepository.findById(id).get(), RoomDTO.class);
    }

    @Override
    public List<RoomDTO> findAllCities() {
        return mapper.mapAll(roomRepository.findAll(), RoomDTO.class);
    }

    @Override
    public RoomDTO deleteRoomById(Long id) {
        Optional<RoomEntity> optionalRoom = roomRepository.findById(id);
        roomRepository.deleteById(id);
        return mapper.map(optionalRoom.get(), RoomDTO.class);
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO) {
        roomRepository.save(mapper.map(roomDTO, RoomEntity.class));
        return roomDTO;
    }
}
