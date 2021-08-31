package com.shymoniak.entity.enums;

import lombok.Getter;

@Getter
public enum AccommodationType {
    HOUSE("House", 1), OFFICE("Office", 2), APARTMENT("Apartment", 3);

    private final Integer id;

    AccommodationType(String typeName, Integer id) {
        this.id = id;
    }
}
