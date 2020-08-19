package com.example.booking.service;

import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.dto.booking.CreateBookingRequestDTO;
import com.example.booking.dto.booking.UpdateBookingRequestDTO;
import com.example.booking.exception.BookingException;

import java.util.List;

public interface BookingService {

    BookingDTO getById(Long id) throws BookingException;

    BookingDTO create(CreateBookingRequestDTO request) throws BookingException;

    BookingDTO update(UpdateBookingRequestDTO request) throws BookingException;

    List<BookingDTO> getList();

    void cancelBooking(Long bookingId) throws BookingException;
}
