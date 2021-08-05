package com.shymoniak.entity.enums;

public enum AccommodationCondition {
    UNSATISFACTORY("Unsatisfactory"), SATISFACTORY("Satisfactory"),
    GOOD("Good"), PERFECT("Perfect");

    private String conditionName;

    AccommodationCondition(String conditionName) {
        this.conditionName = conditionName;
    }
}
