package com.example.booking.mapper;

import com.example.booking.dto.dictionary.DictionaryDTO;
import com.example.booking.model.BaseDictionaryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DictionaryMapper {

    public abstract DictionaryDTO toDTO(BaseDictionaryEntity entity);
}
