package com.example.booking.service.impl;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.dto.room.CreateRoomRequestDTO;
import com.example.booking.dto.room.RoomDTO;
import com.example.booking.dto.room.UpdateRoomRequestDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.mapper.DictionaryMapper;
import com.example.booking.mapper.RoomMapper;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.RoomTypeEntity;
import com.example.booking.repository.RoomRepository;
import com.example.booking.repository.RoomTypeRepository;
import com.example.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomTypeRepository roomTypeRepository;
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final DictionaryMapper dictionaryMapper;

    @Override
    public RoomDTO getById(Long id) throws BookingException {
        return roomMapper.toDTO(roomRepository.findMainEntityById(id));
    }

    @Override
    public RoomDTO create(CreateRoomRequestDTO request) throws BookingException {
        RoomTypeEntity roomType = roomTypeRepository.findMainEntityById(request.getRoomTypeId());

        return roomMapper.toDTO(roomRepository.save(roomMapper.toEntity(request, roomType)));
    }

    @Override
    public RoomDTO update(UpdateRoomRequestDTO request) throws BookingException {
        RoomEntity room = roomRepository.findMainEntityById(request.getId());
        RoomTypeEntity roomType = roomTypeRepository.findMainEntityById(request.getRoomTypeId());

        return roomMapper.toDTO(roomRepository.save(roomMapper.toEntity(room, request, roomType)));
    }

    @Override
    public List<DictionaryDTO> getRoomTypeList() {
        return dictionaryMapper.toListDTO(new ArrayList<>(roomTypeRepository.findAll()));
    }

    @Override
    public List<RoomDTO> getList() {
        return roomMapper.toListDTO(roomRepository.findAll());
    }
}
