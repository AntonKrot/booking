package com.example.booking.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDictionaryEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public abstract Short getId();
}
