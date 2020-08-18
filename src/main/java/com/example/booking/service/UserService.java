package com.example.booking.service;

import com.example.booking.exception.BookingException;
import com.example.booking.model.UserEntity;

public interface UserService {

    UserEntity getById(Long id) throws BookingException;
}
