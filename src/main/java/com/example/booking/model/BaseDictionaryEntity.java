package com.example.booking.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public abstract class BaseDictionaryEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public abstract Short getId();
}
