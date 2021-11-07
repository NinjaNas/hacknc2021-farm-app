package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SeedImpl implements Seed {
    private static Type _seed;
    private static BufferedImage[] _img;

    // Set the seed Type
    public SeedImpl(Type seed) {
        _seed = seed;
    }

    // TODO(Isidro, Khang): balance all the plants and add images
    // Create PlantImpl
    public static PlantImpl plantSeed() {
        switch (_seed) {
            case WHEAT:
                return new PlantImpl("Wheat", Type.WHEAT, 10, 15, 3, 5,_seed.cost);
            case BEET:
                return new PlantImpl("Beet", Type.BEET, 10, 15, 3, 5,_seed.cost);
            case CARROT:
                return new PlantImpl("Carrot", Type.CARROT, 10, 15, 3, 5,_seed.cost);
            case POTATO:
                return new PlantImpl("Potato", Type.POTATO, 10, 15, 3, 5,_seed.cost);
            case BERRIES:
                return new PlantImpl("Berries", Type.BERRIES, 10, 15, 3, 5,_seed.cost);
            // NOTE: make it return an error?
            default:
                return null;
        }
    }

    // Handles the images for the stages of the plant
    public static BufferedImage imageHandler(Plant plant) throws IOException {
        //return ImageIO.read(new File("img.jpg"));
        //Khang: default would be tilled soil
        Type type = plant.getType();
        Plant.GrowthStage growth = plant.getGrowthStage();

        switch (type) {
            case WHEAT:
                switch (growth) {
                    case PREMATURE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/0.png"));
                    case RIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/1.png"));
                    case OVERRIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/2.png"));
                    default:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
                }
            case BEET:
                switch (growth) {
                    case PREMATURE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/0.png"));
                    case RIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/1.png"));
                    case OVERRIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/2.png"));
                    default:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
                }
            case CARROT:
                switch (growth) {
                    case PREMATURE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/0.png"));
                    case RIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/1.png"));
                    case OVERRIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/2.png"));
                    default:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
                }
            case POTATO:
                switch (growth) {
                    case PREMATURE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/0.png"));
                    case RIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/1.png"));
                    case OVERRIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/2.png"));
                    default:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
                }
            case BERRIES:
                switch (growth) {
                    case PREMATURE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/0.png"));
                    case RIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/1.png"));
                    case OVERRIPE:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/2.png"));
                    default:
                        return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
                }
                // NOTE: make it return an error?
            default:
                return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
        }
    }

    // Change the seed Type
    // NOTE: Why is this method here isn't seed supposed to be static?
    public void setCurrentSeed(Type seed) {
        _seed = seed;
    }

    public static void setSeed(Type seed) {
        _seed = seed;
    }
}
