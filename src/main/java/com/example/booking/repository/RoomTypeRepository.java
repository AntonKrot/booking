package com.example.booking.repository;

import com.example.booking.model.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Short> {
}
