package com.example.booking.exception.handler;

import com.example.booking.exception.BookingException;
import com.example.booking.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity handleGenericNotFoundException(BookingException exception) {
        log.error(exception.getMessage(), exception);

        return ResponseEntity
                .status(exception.getCode())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(exception.getMessage());
    }
}
