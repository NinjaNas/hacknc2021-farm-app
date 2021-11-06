package com.hacknc;

public interface Seed {
  void setCurrentSeed(Type seed);

  // The type of seeds
  enum Type {
    WHEAT,
    CORN,
    BEANS,
    CARROT,
    BEET,
    TOMATO;
  }
}
