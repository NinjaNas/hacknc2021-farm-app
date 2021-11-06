package com.hacknc;

public class SeedImpl implements Seed {
  static Type _seed;
  // Set the seed Type
  public SeedImpl(Type seed) {
    _seed = seed;
  }
  // TODO(Isidro, Khang): balance all the plants and add images
  // Create PlantImpl
  public static PlantImpl plantSeed() {
    switch (_seed) {
      case WHEAT:
        return new PlantImpl("Wheat", 10, 15, 3, 5, null);
      case BEANS:
        return new PlantImpl("Beans", 10, 15, 3, 5, null);
      case BEET:
        return new PlantImpl("Beet", 10, 15, 3, 5, null);
      case CARROT:
        return new PlantImpl("Carrot", 10, 15, 3, 5, null);
      case CORN:
        return new PlantImpl("Corn", 10, 15, 3, 5, null);
      case TOMATO:
        return new PlantImpl("Tomato", 10, 15, 3, 5, null);
        // NOTE: make it return an error?
      default:
        return null;
    }
  }

  // Change the seed Type
  // NOTE: Why is this method here isn't seed supposed to be static?
  public void setCurrentSeed(Type seed) {
    _seed = seed;
  }

  public static void setSeed(Type seed)
  {
    _seed = seed;
  }
}
