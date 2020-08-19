package com.example.booking.mapper;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.model.BaseDictionaryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DictionaryMapper {

    public abstract DictionaryDTO toDTO(BaseDictionaryEntity entity);

    public abstract List<DictionaryDTO> toListDTO(List<BaseDictionaryEntity> entities);
}
