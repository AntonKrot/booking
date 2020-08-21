package com.example.booking.controller;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.dto.room.CreateRoomRequestDTO;
import com.example.booking.dto.room.FreeRoomRequestDTO;
import com.example.booking.dto.room.RoomDTO;
import com.example.booking.dto.room.UpdateRoomRequestDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")
    public RoomDTO getById(@PathVariable("id") Long id) throws BookingException {
        return roomService.getById(id);
    }

    @PostMapping("/create")
    public RoomDTO create(@RequestBody CreateRoomRequestDTO request) throws BookingException {
        return roomService.create(request);
    }

    @PostMapping("/update")
    public RoomDTO update(@RequestBody UpdateRoomRequestDTO request) throws BookingException {
        return roomService.update(request);
    }

    @GetMapping("/list")
    public List<RoomDTO> getList() {
        return roomService.getList();
    }

    @PostMapping("/free")
    public List<RoomDTO> getList(@RequestBody FreeRoomRequestDTO request) throws BookingException {
        return roomService.getFreeRoomList(request);
    }

    @GetMapping("/type/list")
    public List<DictionaryDTO> getRoomTypeList() {
        return roomService.getRoomTypeList();
    }
}
