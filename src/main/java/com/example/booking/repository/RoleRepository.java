package com.example.booking.repository;

import com.example.booking.common.BaseRepository;
import com.example.booking.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends BaseRepository<RoleEntity, Short> {
}
