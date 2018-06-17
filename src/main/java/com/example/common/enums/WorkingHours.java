package com.example.common.enums;

public enum WorkingHours {
    HOURS_8("8:00"),
    HOURS_8_30("8:30"),
    HOURS_9("9:00"),
    HOURS_9_30("9:30"),
    HOURS_10("10:00"),
    HOURS_10_30("10:30"),
    HOURS_11("11:00"),
    HOURS_11_30("11:30"),
    HOURS_12("12:00"),
    HOURS_12_30("12:30"),
    HOURS_13("13:00"),
    HOURS_13_30("13:30"),
    HOURS_14("14:00"),
    HOURS_14_30("14:30"),
    HOURS_15("15:00"),
    HOURS_15_30("15:30");

    private String name;

    WorkingHours(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
