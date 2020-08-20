package com.example.booking.exception;

public class FieldValidationException extends BookingException {

    public FieldValidationException(String message) {
        super(message, (short) 422);
    }
}
