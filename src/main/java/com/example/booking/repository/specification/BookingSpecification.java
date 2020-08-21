package com.example.booking.repository.specification;

import com.example.booking.common.PredicateBuilder;
import com.example.booking.dto.booking.BookingSearchCriteriaDTO;
import com.example.booking.model.BookingEntity;
import com.example.booking.model.BookingEntity_;
import com.example.booking.model.BookingStatusEntity;
import com.example.booking.model.BookingStatusEntity_;
import com.example.booking.model.RoomEntity;
import com.example.booking.model.RoomEntity_;
import com.example.booking.model.UserEntity;
import com.example.booking.model.UserEntity_;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingSpecification implements Specification<BookingEntity> {

    private BookingSearchCriteriaDTO criteria;

    @Override
    public Predicate toPredicate(Root<BookingEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        PredicateBuilder predicateBuilder = new PredicateBuilder(builder);

        if (criteria.getUserId() != null) {
            Join<BookingEntity, UserEntity> userJoin = root.join(BookingEntity_.user, JoinType.LEFT);
            predicateBuilder.appendCondition(builder.equal(userJoin.get(UserEntity_.id), criteria.getUserId()));
        }

        if (criteria.getStatusId() != null) {
            Join<BookingEntity, BookingStatusEntity> statusJoin = root.join(BookingEntity_.bookingStatus, JoinType.LEFT);
            predicateBuilder.appendCondition(builder.equal(statusJoin.get(BookingStatusEntity_.id), criteria.getStatusId()));

        }

        if (criteria.getDay() != null) {
            predicateBuilder.appendCondition((builder.and(
                    builder.greaterThanOrEqualTo(root.get(BookingEntity_.startDateTime), criteria.getDay().atTime(LocalTime.MIN)),
                    builder.lessThanOrEqualTo(root.get(BookingEntity_.startDateTime), criteria.getDay().atTime(LocalTime.MAX))
            )));
        }

        if (criteria.getRoomId() != null) {
            Join<BookingEntity, RoomEntity> roomJoin = root.join(BookingEntity_.room, JoinType.LEFT);
            predicateBuilder.appendCondition(builder.equal(roomJoin.get(RoomEntity_.id), criteria.getRoomId()));
        }

        return predicateBuilder.getPredicate();
    }

}
