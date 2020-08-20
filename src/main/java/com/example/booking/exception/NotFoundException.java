package com.example.booking.exception;

import com.example.booking.enums.ErrorTypeEnum;

public class NotFoundException extends BookingException {

    public NotFoundException(String message) {
        super(message, ErrorTypeEnum.NOT_FOUND_ERROR.getResponseStatusCode());
    }
}
