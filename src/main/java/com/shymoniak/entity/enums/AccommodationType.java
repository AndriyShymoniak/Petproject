package com.shymoniak.entity.enums;

public enum AccommodationType {
    HOUSE("House"), OFFICE("Office"), APARTMENT("Apartment");

    private String typeName;

    AccommodationType(String typeName) {
        this.typeName = typeName;
    }
}
