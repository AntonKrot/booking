package com.example.booking.repository;

import com.example.booking.common.BaseRepository;
import com.example.booking.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Long> {
}
