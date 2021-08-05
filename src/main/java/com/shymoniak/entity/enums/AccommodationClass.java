package com.shymoniak.entity.enums;

public enum AccommodationClass {
    ECONOMIC("Economic"), COMFORT ("Comfort"),
    BUSINESS("Business"), ELITE("Elite");

    private String className;

    AccommodationClass(String className) {
        this.className = className;
    }
}
