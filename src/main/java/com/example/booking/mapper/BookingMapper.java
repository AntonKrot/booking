package com.example.booking.mapper;

import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.model.BookingEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class BookingMapper {

    public abstract BookingDTO toDTO(BookingEntity entity);
}
