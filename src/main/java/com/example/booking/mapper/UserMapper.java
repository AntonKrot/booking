package com.example.booking.mapper;

import com.example.booking.dto.user.UserDTO;
import com.example.booking.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class UserMapper {

    public abstract UserDTO toDTO(UserEntity entity);
}
