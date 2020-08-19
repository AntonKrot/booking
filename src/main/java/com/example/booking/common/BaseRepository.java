package com.example.booking.common;

import com.example.booking.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    default T findMainEntityById(ID id) throws NotFoundException {
        if (id == null) {
            throw new NotFoundException("Id is null");
        } else {
            return this.findById(id).orElseThrow(() -> {
                return new NotFoundException("Not found by id = " + id);
            });
        }
    }
}
