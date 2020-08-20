package com.example.booking.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingSearchCriteriaDTO {

    private Long roomId;
    private Long userId;
    private Short statusId;
    private LocalDate day;
}
