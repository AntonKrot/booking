package com.example.booking.service;

import com.example.booking.dto.user.UserDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.model.UserEntity;

public interface UserService {

    UserDTO getById(Long id) throws BookingException;
}
