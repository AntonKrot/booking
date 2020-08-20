package com.example.booking.exception;

public class BusinessConstraintViolationException extends BookingException {

    public BusinessConstraintViolationException(String message) {
        super(message, (short) 409);
    }
}
