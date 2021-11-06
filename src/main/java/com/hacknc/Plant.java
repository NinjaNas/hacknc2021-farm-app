package com.hacknc;

import java.awt.*;

public interface Plant {
  // Getters and setters
  String getName();

  int getRipe();

  int getOverRipe();

  long getTimePlanted();

  int getYield();

  int setYield(int amount);

  long getNutrientIn();

  Image getImage();

  GrowthStage getGrowthStage();
  // The update method takes the delta time and uses it to update fields
  long update(long delta, long nutri);
  // enum for the growth stages
  enum GrowthStage {
    UNPLANTED,
    PREMATURE,
    RIPE,
    OVERRIPE
  }
}
