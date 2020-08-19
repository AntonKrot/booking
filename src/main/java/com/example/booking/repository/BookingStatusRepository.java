package com.example.booking.repository;

import com.example.booking.model.BookingStatusEntity;
import com.example.booking.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusRepository  extends JpaRepository<BookingStatusEntity, Short> {
}
