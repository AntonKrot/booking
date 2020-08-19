package com.example.booking.mapper;

import com.example.booking.dto.room.RoomDTO;
import com.example.booking.model.RoomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class RoomMapper {

    public abstract RoomDTO toDTO(RoomEntity entity);
}
