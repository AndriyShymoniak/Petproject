package com.shymoniak.entity.enums;

import lombok.Getter;

@Getter
public enum AccommodationClass {
    ECONOMIC("Economic", 1), COMFORT("Comfort", 2),
    BUSINESS("Business", 3), ELITE("Elite", 4);

    private final Integer id;

    AccommodationClass(String className, Integer id) {
        this.id = id;
    }
}
