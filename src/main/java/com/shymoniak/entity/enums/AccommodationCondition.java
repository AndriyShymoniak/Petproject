package com.shymoniak.entity.enums;

import lombok.Getter;

@Getter
public enum AccommodationCondition {
    UNSATISFACTORY("Unsatisfactory", 1), SATISFACTORY("Satisfactory", 2),
    GOOD("Good", 3), PERFECT("Perfect", 4);

    private final Integer id;

    AccommodationCondition(String conditionName, Integer id) {
        this.id = id;
    }
}
