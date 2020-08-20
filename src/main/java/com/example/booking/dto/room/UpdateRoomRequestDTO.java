package com.example.booking.dto.room;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateRoomRequestDTO {

    @NotNull
    private Long id;
    @NotNull
    private Short roomTypeId;
    private String description;
}
