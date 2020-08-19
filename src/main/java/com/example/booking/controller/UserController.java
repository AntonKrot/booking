package com.example.booking.controller;

import com.example.booking.dto.user.CreateUserRequestDTO;
import com.example.booking.dto.user.UpdateUserRequestDTO;
import com.example.booking.dto.user.UserDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") Long id) throws BookingException {
        return userService.getById(id);
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody CreateUserRequestDTO request) throws BookingException {
        return userService.create(request);
    }

    @PostMapping("/update")
    public UserDTO update(@RequestBody UpdateUserRequestDTO request) throws BookingException {
        return userService.update(request);
    }

    @GetMapping("/list")
    public List<UserDTO> getList() {
        return userService.getList();
    }
}
