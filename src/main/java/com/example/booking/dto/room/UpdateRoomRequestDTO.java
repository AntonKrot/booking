package com.example.booking.dto.room;

import lombok.Data;

@Data
public class UpdateRoomRequestDTO {

    private Long id;
    private String description;
    private Short roomTypeId;
}
