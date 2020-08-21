package com.example.booking.repository;

import com.example.booking.common.BaseRepository;
import com.example.booking.model.RoomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends BaseRepository<RoomEntity, Long> {

    @Query(value = "select * " +
            "from room r " +
            "where not exists( " +
            "select b " +
            "from booking b " +
            "where b.room_id = r.room_id " +
            "and ((b.start_date_time <= :start and b.end_date_time > :start) " +
            "or (b.start_date_time < :end and b.end_date_time >= :end)))", nativeQuery = true)
    List<RoomEntity> findAllFreeRoom(@Param("start") LocalDateTime startDateTime, @Param("end") LocalDateTime endDateTime);
}
