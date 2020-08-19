package com.example.booking.controller;

import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.dto.booking.CreateBookingRequestDTO;
import com.example.booking.dto.booking.UpdateBookingRequestDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{id}")
    public BookingDTO getById(@PathVariable("id") Long id) throws BookingException {
        return bookingService.getById(id);
    }

    @PostMapping("/create")
    public BookingDTO create(@RequestBody CreateBookingRequestDTO request) throws BookingException {
        return bookingService.create(request);
    }

    @PostMapping("/update")
    public BookingDTO update(@RequestBody UpdateBookingRequestDTO request) throws BookingException {
        return bookingService.update(request);
    }

    @GetMapping("/list")
    public List<BookingDTO> getList() {
        return bookingService.getList();
    }
}
