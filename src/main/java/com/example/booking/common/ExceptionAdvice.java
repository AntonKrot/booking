package com.example.booking.common;

import com.example.booking.exception.BookingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(value = BookingException.class)
    public ResponseEntity handleBookingException(BookingException exception) {
        log.error(exception.getMessage(), exception);

        return ResponseEntity
                .status(exception.getCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());
    }

    // todo add redirect
    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity handleAccessDeniedException(RuntimeException exception) {
        log.error("Access denied", exception);
        return ResponseEntity
                .status(403)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());
    }
}
