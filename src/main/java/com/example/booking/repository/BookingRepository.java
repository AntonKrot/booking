package com.example.booking.repository;

import com.example.booking.common.BaseRepository;
import com.example.booking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends BaseRepository<BookingEntity, Long>, JpaSpecificationExecutor<BookingEntity> {

    @Query(value = "select exists(select b " +
            "from booking b " +
            "where b.user_account_id = :userId " +
            "and ((b.start_date_time <= :startDateTime and b.end_date_time > :startDateTime) " +
            "or  (b.start_date_time < :endDateTime and b.end_date_time >= :endDateTime)))", nativeQuery = true)
    Boolean isIntersectingManipulationForUser(@Param("userId") Long userId, @Param("startDateTime") LocalDateTime startDateTime,
                                              @Param("endDateTime") LocalDateTime endDateTime);

    @Query(value = "select exists(select b " +
            "from booking b " +
            "where b.room_id = :roomId " +
            "and ((b.start_date_time <= :startDateTime and b.end_date_time > :startDateTime) " +
            "or  (b.start_date_time < :endDateTime and b.end_date_time >= :endDateTime)))", nativeQuery = true)
    Boolean isTakenBookingTime(@Param("roomId") Long roomId, @Param("startDateTime") LocalDateTime startDateTime,
                               @Param("endDateTime") LocalDateTime endDateTime);

    @Query(value = "select * " +
            "from booking b " +
            "where b.end_date_time between :startDay and :endDay and b.booking_status_id = :statusId group by b.booking_id", nativeQuery = true)
    List<BookingEntity> findAllByDayAndBookingStatus(@Param("startDay") LocalDateTime startDay,
                                                     @Param("endDay") LocalDateTime endDay,
                                                     @Param("statusId") Short statusId);
}
