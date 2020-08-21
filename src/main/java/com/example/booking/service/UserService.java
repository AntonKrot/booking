package com.example.booking.service;

import com.example.booking.dto.user.CreateUserRequestDTO;
import com.example.booking.dto.user.UpdateUserRequestDTO;
import com.example.booking.dto.user.UserDTO;
import com.example.booking.exception.BookingException;

import java.util.List;

public interface UserService {

    UserDTO getById(Long id) throws BookingException;

    UserDTO create(CreateUserRequestDTO request) throws BookingException;

    UserDTO update(UpdateUserRequestDTO request) throws BookingException;

    List<UserDTO> getList();

    UserDTO getCurrentUser() throws BookingException;
}
