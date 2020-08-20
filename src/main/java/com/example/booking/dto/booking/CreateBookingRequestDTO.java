package com.example.booking.dto.booking;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CreateBookingRequestDTO {

    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;
    @NotBlank
    private String manipulationName;
    private String manipulationDescription;
    @NotNull
    private Long roomId;
}
