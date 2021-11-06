package com.hacknc;

import java.awt.image.BufferedImage;

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
        return new PlantImpl("Wheat", Type.WHEAT, 10, 15, 3, 5);
      case BEET:
        return new PlantImpl("Beet", Type.BEET, 10, 15, 3, 5);
      case CARROT:
        return new PlantImpl("Carrot", Type.CARROT, 10, 15, 3, 5);
      case POTATO:
        return new PlantImpl("Potato", Type.POTATO, 10, 15, 3, 5);
      case BERRIES:
        return new PlantImpl("Berries", Type.BERRIES, 10, 15, 3, 5);
        // NOTE: make it return an error?
      default:
        return null;
    }
  }

  // Handles the images for the stages of the plant
  public static BufferedImage imageHandler(Plant plant) {
    //return ImageIO.read(new File("img.jpg"));
    //Khang: default would be tilled soil
    switch (plant.getType()) {
      case WHEAT:
        switch (plant.getGrowthStage()) {
          case PREMATURE:
            return null;
          case RIPE:
            return null;
          case OVERRIPE:
            return null;
          default:
            return null;
        }
      case BEET:
        switch (plant.getGrowthStage()) {
          case PREMATURE:
            return null;
          case RIPE:
            return null;
          case OVERRIPE:
            return null;
          default:
            return null;
        }
      case CARROT:
        switch (plant.getGrowthStage()) {
          case PREMATURE:
            return null;
          case RIPE:
            return null;
          case OVERRIPE:
            return null;
          default:
            return null;
        }
      case POTATO:
        switch (plant.getGrowthStage()) {
          case PREMATURE:
            return null;
          case RIPE:
            return null;
          case OVERRIPE:
            return null;
          default:
            return null;
        }
      case BERRIES:
        switch (plant.getGrowthStage()) {
          case PREMATURE:
            return null;
          case RIPE:
            return null;
          case OVERRIPE:
            return null;
          default:
            return null;
        }
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
}
