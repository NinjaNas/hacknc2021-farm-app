package com.hacknc;

public interface Seed {
  void setCurrentSeed(Type seed);

  // The type of seeds
  enum Type {
    WHEAT,
    CARROT,
    BEET,
    POTATO,
    BERRIES;
  }
}
