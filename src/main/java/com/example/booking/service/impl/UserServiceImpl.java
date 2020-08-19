package com.example.booking.service.impl;

import com.example.booking.dto.user.UserDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.exception.NotFoundException;
import com.example.booking.mapper.UserMapper;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getById(Long id) throws BookingException {
        return userMapper.toDTO(userRepository.findMainEntityById(id));
    }
}
