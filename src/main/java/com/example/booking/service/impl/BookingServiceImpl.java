package com.example.booking.service.impl;

import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.dto.booking.CreateBookingRequestDTO;
import com.example.booking.dto.booking.UpdateBookingRequestDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.mapper.BookingMapper;
import com.example.booking.model.BookingEntity;
import com.example.booking.model.BookingStatusEntity;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.UserEntity;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.BookingStatusRepository;
import com.example.booking.repository.RoomRepository;
import com.example.booking.repository.UserRepository;
import com.example.booking.security.AuthenticationFacade;
import com.example.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.booking.enums.BookingStatusEnum.CANCELED;
import static com.example.booking.enums.BookingStatusEnum.NEW;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public BookingDTO getById(Long id) throws BookingException {
        return bookingMapper.toDTO(bookingRepository.findMainEntityById(id));
    }

    @Override
    public BookingDTO create(CreateBookingRequestDTO request) throws BookingException {
        UserEntity user = userRepository.findMainEntityById(authenticationFacade.getUserDetails().getId());
        BookingStatusEntity bookingStatusEntity = bookingStatusRepository.findMainEntityById(NEW.getId());
        RoomEntity room = roomRepository.findMainEntityById(request.getRoomId());

        return bookingMapper.toDTO(bookingRepository.save(bookingMapper.toEntity(request, room, bookingStatusEntity, user)));
    }

    @Override
    public BookingDTO update(UpdateBookingRequestDTO request) throws BookingException {
        //todo check booking user and auth user
        BookingEntity booking = bookingRepository.findMainEntityById(request.getId());
        RoomEntity room = roomRepository.findMainEntityById(request.getRoomId());

        return bookingMapper.toDTO(bookingRepository.save(bookingMapper.toEntity(booking, request, room)));
    }

    @Override
    public List<BookingDTO> getList() {
        return bookingMapper.toListDTO(bookingRepository.findAll());
    }

    @Override
    public void cancelBooking(Long bookingId) throws BookingException {
        //todo check booking user and auth user
        BookingEntity booking = bookingRepository.findMainEntityById(bookingId);
        booking.setBookingStatus(bookingStatusRepository.findMainEntityById(CANCELED.getId()));
        bookingRepository.save(booking);
    }
}
