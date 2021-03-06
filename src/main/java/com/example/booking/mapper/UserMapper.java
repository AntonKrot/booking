package com.example.booking.mapper;

import com.example.booking.dto.user.CreateUserRequestDTO;
import com.example.booking.dto.user.InternalUserDetailsDTO;
import com.example.booking.dto.user.UpdateUserRequestDTO;
import com.example.booking.dto.user.UserDTO;
import com.example.booking.model.RoleEntity;
import com.example.booking.model.UserEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DictionaryMapper.class})
public abstract class UserMapper {

    public abstract UserDTO toDTO(UserEntity entity);

    public abstract List<UserDTO> toListDTO(List<UserEntity> entities);
    @Mappings({
    @Mapping(target = "role", expression = "java(role)"),
    @Mapping(target = "password", expression = "java(password)"),
    })
    public abstract UserEntity toEntity(CreateUserRequestDTO dto,
                                        @Context RoleEntity role,
                                        String password);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "role", expression = "java(role)"),
    })
    public abstract UserEntity toEntity(@MappingTarget UserEntity entity,
                                        UpdateUserRequestDTO dto,
                                        @Context RoleEntity role);

    @Mapping(target = "roleId", source = "role.id")
    public abstract InternalUserDetailsDTO toUserDetailDTO(UserEntity user);
}
