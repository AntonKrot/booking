package com.example.booking.dto.booking;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.dto.room.RoomDTO;
import com.example.booking.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String manipulationName;
    private String manipulationDescription;
    private RoomDTO room;
    private UserDTO user;
    private DictionaryDTO bookingStatus;
}
