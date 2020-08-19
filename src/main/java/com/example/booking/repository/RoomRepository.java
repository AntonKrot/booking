package com.example.booking.repository;

import com.example.booking.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository  extends JpaRepository<RoomEntity, Long> {
}
