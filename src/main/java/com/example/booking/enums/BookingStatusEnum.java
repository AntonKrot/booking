package com.example.booking.enums;

import com.example.booking.common.BaseDictionaryEnum;
import lombok.Getter;

@Getter
public enum BookingStatusEnum implements BaseDictionaryEnum {
    NEW(1),
    IN_PROCESS(2),
    FINISHED(3),
    CANCELED(4);

    private Short id;

    BookingStatusEnum(int id) {
        this.id = (short) id;
    }
}
