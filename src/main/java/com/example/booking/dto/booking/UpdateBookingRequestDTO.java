package com.example.booking.dto.booking;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class UpdateBookingRequestDTO {

    @NotNull
    private Long id;
    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;
    @NotNull
    private String manipulationName;
    private String manipulationDescription;
    @NotNull
    private Long roomId;
}
