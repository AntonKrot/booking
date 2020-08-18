package com.example.booking.service.impl;

import com.example.booking.exception.BookingException;
import com.example.booking.exception.NotFoundException;
import com.example.booking.model.UserEntity;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getById(Long id) throws BookingException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found by id = " + id));
    }
}
