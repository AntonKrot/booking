package com.example.booking.service;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.dto.room.CreateRoomRequestDTO;
import com.example.booking.dto.room.FreeRoomRequestDTO;
import com.example.booking.dto.room.RoomDTO;
import com.example.booking.dto.room.UpdateRoomRequestDTO;
import com.example.booking.exception.BookingException;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomService {

    RoomDTO getById(Long id) throws BookingException;

    RoomDTO create(CreateRoomRequestDTO request) throws BookingException;

    RoomDTO update(UpdateRoomRequestDTO request) throws BookingException;

    List<DictionaryDTO> getRoomTypeList();

    List<RoomDTO> getList();

    List<RoomDTO> getFreeRoomList(FreeRoomRequestDTO request) throws BookingException;
}
