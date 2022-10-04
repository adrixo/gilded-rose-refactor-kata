package com.gildedrose.characterization.threshold;

public class Threshold implements ThresholdI {

    private final int value;
    private final String direction;

    public Threshold(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public boolean belongs(int compared) {
        return switch (direction) {
            case "<" -> value < compared;
            case "<=" -> value <= compared;
            case ">=" -> value >= compared;
            case ">" -> value > compared;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }
}
