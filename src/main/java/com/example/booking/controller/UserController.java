package com.example.booking.controller;

import com.example.booking.exception.BookingException;
import com.example.booking.model.UserEntity;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") Long id) throws BookingException {
        return userService.getById(id);
    }
}
