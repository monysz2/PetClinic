package com.example.common.enums;

public enum AnimalType {
    CAT("Kot"),
    DOG("PIes"),
    RAT("Szczur"),
    RABBIT("Królik"),
    HAMSTER("Chomik");

    private String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
