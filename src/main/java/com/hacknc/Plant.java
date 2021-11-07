package com.hacknc;

public interface Plant {
    // Getters and setters
    String getName();

    Seed.Type getType();

    int getRipe();

    int getOverRipe();

    double getTimePlanted();

    int getYield();

    int setYield(int amount);

    double getNutrientIn();

    GrowthStage getGrowthStage();

    // The update method takes the delta time and uses it to update fields
    double update(double delta, double nutri);

    // enum for the growth stages
    enum GrowthStage {
        UNPLANTED,
        PREMATURE,
        RIPE,
        OVERRIPE
    }
}
