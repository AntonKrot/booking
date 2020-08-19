package com.example.booking.dto.room;

import lombok.Data;

@Data
public class CreateRoomRequestDTO {

    private String description;
    private Short roomTypeId;
}
