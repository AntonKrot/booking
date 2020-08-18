package com.example.booking.exception;

import com.example.booking.enums.ErrorTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found")
@Slf4j
public class NotFoundException extends BookingException {

    public NotFoundException(String message) {
        super(message, ErrorTypeEnum.NOT_FOUND_ERROR.getResponseStatusCode());
    }
}
