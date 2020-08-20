package com.example.booking.exception;

import lombok.Getter;

@Getter
public class BookingException extends Exception {

    private Short code;

    public BookingException(String message, Short code) {
        super(message);
        this.code = code;
    }
}
