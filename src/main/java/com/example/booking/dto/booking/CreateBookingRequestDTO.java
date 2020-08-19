package com.example.booking.dto.booking;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBookingRequestDTO {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String manipulationName;
    private String manipulationDescription;
    private Long roomId;
}
