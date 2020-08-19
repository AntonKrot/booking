package com.example.booking.mapper;

import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.dto.booking.CreateBookingRequestDTO;
import com.example.booking.dto.booking.UpdateBookingRequestDTO;
import com.example.booking.model.BookingEntity;
import com.example.booking.model.BookingStatusEntity;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.UserEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class BookingMapper {

    public abstract BookingDTO toDTO(BookingEntity entity);

    public abstract List<BookingDTO> toListDTO(List<BookingEntity> entities);

    @Mappings({
            @Mapping(target = "room", expression = "java(room)"),
            @Mapping(target = "bookingStatus", expression = "java(bookingStatus)"),
            @Mapping(target = "user", expression = "java(user)")
    })
    public abstract BookingEntity toEntity(CreateBookingRequestDTO dto,
                                           @Context RoomEntity room,
                                           @Context BookingStatusEntity bookingStatus,
                                           @Context UserEntity user);

    @Mappings({
            @Mapping(target = "room", expression = "java(room)")
    })
    public abstract BookingEntity toEntity(@MappingTarget BookingEntity booking,
                                           UpdateBookingRequestDTO dto,
                                           @Context RoomEntity room);
}
