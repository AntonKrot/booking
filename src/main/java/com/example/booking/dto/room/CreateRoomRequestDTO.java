package com.example.booking.dto.room;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateRoomRequestDTO {

    @NotNull
    private Short roomTypeId;
    private String description;
}
