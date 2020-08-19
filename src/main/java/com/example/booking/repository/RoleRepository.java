package com.example.booking.repository;

import com.example.booking.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<RoleEntity, Short> {
}
