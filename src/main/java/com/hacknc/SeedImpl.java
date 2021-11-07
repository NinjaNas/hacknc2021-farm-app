package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


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
                return new PlantImpl("Wheat", Type.WHEAT, 40, 55, 49, 12); // four months to mature and yields about 49.7 bushels per acre
            case BEET:
                return new PlantImpl("Beet", Type.BEET, 20, 30, 22, 10); // about two months to grow and yields about 19-22 tons per acre and if left in the ground too long the beets will continue to grow and the beetroot will eventually get to large
            case CARROT:
                return new PlantImpl("Carrot", Type.CARROT, 30, 40, 9, 7); // about three months to grow and yields about 8.8 tons per acre and if left unharvested the carrot will continue to grow but they usually do not get tastier and get bitter
            case POTATO:
                return new PlantImpl("Potato", Type.POTATO, 35, 40, 9, 7); // about 3.5 months to grow and yields about 8.8 tons per acre, if the potato is left the ground it can create a condition that will either rot or encorage sprouting
            case BERRIES:
                return new PlantImpl("Berries", Type.BERRIES, 75, 85, 25, 5); // aobut 7.5 months to grow and yields about 25 tons per acre
            // NOTE: make it return an error?
            default:
                return null;
        }
    }

    // Handles the images for the stages of the plant
    public static BufferedImage imageHandler(Plant plant) throws IOException {
        //return ImageIO.read(new File("img.jpg"));
        //Khang: default would be tilled soil
        switch (plant.getType()) {
            case WHEAT:
                switch (plant.getGrowthStage()) {
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
                switch (plant.getGrowthStage()) {
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
                switch (plant.getGrowthStage()) {
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
                switch (plant.getGrowthStage()) {
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
                switch (plant.getGrowthStage()) {
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
