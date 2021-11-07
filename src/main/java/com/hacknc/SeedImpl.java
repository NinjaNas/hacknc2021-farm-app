package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SeedImpl implements Seed {
    private static Type _seed;
    private static ImageIcon _farmland;
    private static ImageIcon[][] _img = new ImageIcon[5][3];

    // Set the seed Type
    public SeedImpl(Type seed) {
        _seed = seed;
    }

    public static void init() throws IOException {
        _farmland = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[0][0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/0.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[0][1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/1.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[0][2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/wheat/2.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[1][0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/0.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[1][1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/1.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[1][2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/beet/2.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[2][0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/0.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[2][1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/1.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[2][2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/carrot/2.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[3][0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/0.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[3][1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/1.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[3][2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/potato/2.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[4][0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/0.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[4][1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/1.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[4][2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/crops/berries/2.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
    }

    // TODO(Isidro, Khang): balance all the plants and add images
    // Create PlantImpl
    public static PlantImpl plantSeed() {
        switch (_seed) {
            case WHEAT:
                return new PlantImpl("Wheat", Type.WHEAT, 40, 55, 49, 12, _seed.cost); // four months to mature and yields about 49.7 bushels per acre
            case BEET:
                return new PlantImpl("Beet", Type.BEET, 20, 30, 22, 10, _seed.cost); // about two months to grow and yields about 19-22 tons per acre and if left in the ground too long the beets will continue to grow and the beetroot will eventually get to large
            case CARROT:
                return new PlantImpl("Carrot", Type.CARROT, 30, 40, 9, 7, _seed.cost); // about three months to grow and yields about 8.8 tons per acre and if left unharvested the carrot will continue to grow but they usually do not get tastier and get bitter
            case POTATO:
                return new PlantImpl("Potato", Type.POTATO, 35, 40, 9, 7, _seed.cost); // about 3.5 months to grow and yields about 8.8 tons per acre, if the potato is left the ground it can create a condition that will either rot or encorage sprouting
            case BERRIES:
                return new PlantImpl("Berries", Type.BERRIES, 75, 85, 25, 5, _seed.cost); // aobut 7.5 months to grow and yields about 25 tons per acre
            // NOTE: make it return an error?
            default:
                return null;
        }
    }

    // Handles the images for the stages of the plant
    public static ImageIcon imageHandler(Plant plant) throws IOException {
        //return ImageIO.read(new File("img.jpg"));
        //Khang: default would be tilled soil
        Type type = plant.getType();
        Plant.GrowthStage growth = plant.getGrowthStage();

        switch (type) {
            case WHEAT:
                switch (growth) {
                    case PREMATURE:
                        return _img[0][0];
                    case RIPE:
                        return _img[0][1];
                    case OVERRIPE:
                        return _img[0][2];
                    default:
                        return _farmland;
                }
            case BEET:
                switch (growth) {
                    case PREMATURE:
                        return _img[1][0];
                    case RIPE:
                        return _img[1][1];
                    case OVERRIPE:
                        return _img[1][2];
                    default:
                        return _farmland;
                }
            case CARROT:
                switch (growth) {
                    case PREMATURE:
                        return _img[2][0];
                    case RIPE:
                        return _img[2][1];
                    case OVERRIPE:
                        return _img[2][2];
                    default:
                        return _farmland;
                }
            case POTATO:
                switch (growth) {
                    case PREMATURE:
                        return _img[3][0];
                    case RIPE:
                        return _img[3][1];
                    case OVERRIPE:
                        return _img[3][2];
                    default:
                        return _farmland;
                }
            case BERRIES:
                switch (growth) {
                    case PREMATURE:
                        return _img[4][0];
                    case RIPE:
                        return _img[4][1];
                    case OVERRIPE:
                        return _img[4][2];
                    default:
                        return _farmland;
                }
                // NOTE: make it return an error?
            default:
                return _farmland;
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
