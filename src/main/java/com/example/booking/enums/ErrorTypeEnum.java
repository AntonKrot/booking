package com.example.booking.enums;

import lombok.Getter;

@Getter
public enum ErrorTypeEnum {
    NOT_FOUND_ERROR(404);

    private Short responseStatusCode;

    ErrorTypeEnum(int responseStatusCode) {
        this.responseStatusCode = (short) responseStatusCode;
    }
}
