package com.example.booking.service.impl;

import com.example.booking.common.FieldValidator;
import com.example.booking.dto.booking.BookingDTO;
import com.example.booking.dto.booking.BookingSearchCriteriaDTO;
import com.example.booking.dto.booking.CreateBookingRequestDTO;
import com.example.booking.dto.booking.UpdateBookingRequestDTO;
import com.example.booking.exception.BookingException;
import com.example.booking.exception.BusinessConstraintViolationException;
import com.example.booking.mapper.BookingMapper;
import com.example.booking.model.BookingEntity;
import com.example.booking.model.BookingStatusEntity;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.UserEntity;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.BookingStatusRepository;
import com.example.booking.repository.RoomRepository;
import com.example.booking.repository.UserRepository;
import com.example.booking.repository.specification.BookingSpecification;
import com.example.booking.security.AuthenticationFacade;
import com.example.booking.service.BookingService;
import com.example.booking.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.booking.enums.BookingStatusEnum.CANCELED;
import static com.example.booking.enums.BookingStatusEnum.NEW;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    private final AuthenticationFacade authenticationFacade;
    private final FieldValidator fieldValidator;

    @Override
    public BookingDTO getById(Long id) throws BookingException {
        return bookingMapper.toDTO(bookingRepository.findMainEntityById(id));
    }

    @Override
    public BookingDTO create(CreateBookingRequestDTO request) throws BookingException {
        fieldValidator.verify(request);
        DateTimeUtils.validateTimeInterval(request.getStartDateTime(), request.getEndDateTime());

        UserEntity user = userRepository.findMainEntityById(authenticationFacade.getUserDetails().getId());
        checkIntersectingManipulations(user.getId(), request.getStartDateTime(), request.getEndDateTime());

        RoomEntity room = roomRepository.findMainEntityById(request.getRoomId());
        checkTakenBookingTime(room.getId(), request.getStartDateTime(), request.getEndDateTime());

        BookingStatusEntity bookingStatusEntity = bookingStatusRepository.findMainEntityById(NEW.getId());

        return bookingMapper.toDTO(bookingRepository.save(bookingMapper.toEntity(request, room, bookingStatusEntity, user)));
    }

    private void checkIntersectingManipulations(Long userId, LocalDateTime start, LocalDateTime end) throws BusinessConstraintViolationException {
        if (bookingRepository.isIntersectingManipulationForUser(userId, start, end)) {
            throw new BusinessConstraintViolationException("You can't have intersecting manipulations");
        }
    }

    private void checkTakenBookingTime(Long roomId, LocalDateTime start, LocalDateTime end) throws BusinessConstraintViolationException {
        if (bookingRepository.isTakenBookingTime(roomId, start, end)) {
            throw new BusinessConstraintViolationException("This time is taken");
        }
    }

    @Override
    public BookingDTO update(UpdateBookingRequestDTO request) throws BookingException {
        fieldValidator.verify(request);
        DateTimeUtils.validateTimeInterval(request.getStartDateTime(), request.getEndDateTime());

        BookingEntity booking = bookingRepository.findMainEntityById(request.getId());
        checkAccess(booking.getUser().getId());

        RoomEntity room = roomRepository.findMainEntityById(request.getRoomId());

        return bookingMapper.toDTO(bookingRepository.save(bookingMapper.toEntity(booking, request, room)));
    }

    private void checkAccess(Long userId) {
        if (!userId.equals(authenticationFacade.getUserDetails().getId())) {
            throw new AccessDeniedException("Only the person who made the reservation can change the reservation");
        }
    }

    @Override
    public List<BookingDTO> getList(BookingSearchCriteriaDTO criteria) {
        return bookingMapper.toListDTO(bookingRepository.findAll(new BookingSpecification(criteria)));
    }

    @Override
    public void cancelBooking(Long bookingId) throws BookingException {
        BookingEntity booking = bookingRepository.findMainEntityById(bookingId);
        checkAccess(booking.getUser().getId());

        booking.setBookingStatus(bookingStatusRepository.findMainEntityById(CANCELED.getId()));
        bookingRepository.save(booking);
    }
}
