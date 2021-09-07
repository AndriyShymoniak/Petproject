package com.shymoniak.entity.enums;

import lombok.Getter;

@Getter
public enum AccommodationType {
    APARTMENT("Apartment", 1),
    HOUSE("House", 2),
    OFFICE("Office", 3),;

    private final Integer id;

    AccommodationType(String typeName, Integer id) {
        this.id = id;
    }
}
