package com.example.booking.service.impl;

import com.example.booking.common.FieldValidator;
import com.example.booking.dto.user.CreateUserRequestDTO;
import com.example.booking.dto.user.InternalUserDetailsDTO;
import com.example.booking.dto.user.UpdateUserRequestDTO;
import com.example.booking.dto.user.UserDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.mapper.UserMapper;
import com.example.booking.model.RoleEntity;
import com.example.booking.model.UserEntity;
import com.example.booking.repository.RoleRepository;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.InternalUserDetailsService;
import com.example.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, InternalUserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final FieldValidator fieldValidator;

    @Override
    public UserDTO getById(Long id) throws BookingException {
        return userMapper.toDTO(userRepository.findMainEntityById(id));
    }

    @Override
    public UserDTO create(CreateUserRequestDTO request) throws BookingException {
        fieldValidator.verify(request);

        RoleEntity role = roleRepository.findMainEntityById(request.getRoleId());

        return userMapper.toDTO(userRepository.save(userMapper.toEntity(request, role,
                bCryptPasswordEncoder.encode(request.getPassword()))));
    }

    @Override
    public UserDTO update(UpdateUserRequestDTO request) throws BookingException {
        fieldValidator.verify(request);

        UserEntity user = userRepository.findMainEntityById(request.getId());
        RoleEntity role = roleRepository.findMainEntityById(request.getRoleId());

        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user, request, role)));
    }

    public List<UserDTO> getList() {
        return userMapper.toListDTO(userRepository.findAll());
    }

    @Override
    public InternalUserDetailsDTO getUserByLogin(String login) {
        return userMapper.toUserDetailDTO(userRepository.findByLogin(login));
    }
}
