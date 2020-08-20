package com.example.booking.utils;

import com.example.booking.exception.BusinessConstraintViolationException;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DateTimeUtils {

    public void validateTimeInterval(LocalDateTime start, LocalDateTime end) throws BusinessConstraintViolationException {
        if (start.isAfter(end) || start.equals(end)) {
            throw new BusinessConstraintViolationException("Start date can't be after or equals end date");
        }
    }
}
