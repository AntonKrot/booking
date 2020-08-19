package com.example.booking.repository;

import com.example.booking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<BookingEntity, Long> {
}
