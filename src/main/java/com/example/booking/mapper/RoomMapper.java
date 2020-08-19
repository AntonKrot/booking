package com.example.booking.mapper;

import com.example.booking.dto.room.CreateRoomRequestDTO;
import com.example.booking.dto.room.RoomDTO;
import com.example.booking.dto.room.UpdateRoomRequestDTO;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.RoomTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class RoomMapper {

    public abstract RoomDTO toDTO(RoomEntity entity);

    public abstract List<RoomDTO> toListDTO(List<RoomEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roomType", expression = "java(roomType)")
    })
    public abstract RoomEntity toEntity(CreateRoomRequestDTO dto,
                                        RoomTypeEntity roomType);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roomType", expression = "java(roomType)")
    })
    public abstract RoomEntity toEntity(@MappingTarget RoomEntity entity,
                                        UpdateRoomRequestDTO dto,
                                        RoomTypeEntity roomType);
}
