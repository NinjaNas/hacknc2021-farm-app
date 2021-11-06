package com.hacknc.utils;

enum Type {
    WHEAT,
    CORN,
    BEANS,
    CARROT,
    BEET,
    TOMATO;
}

public final class Seed {
    static Type seed;

    public Seed(Type seed) {
        Seed.seed = seed;
    }
    // TODO(Isidro, Khang): balance all the plants 
    public static PlantImpl plantSeed() {
        switch (seed) {
            case WHEAT:
                return new PlantImpl("Wheat", 10, 15, 3, 5, "image");
                break;
            case BEANS:
                return new PlantImpl("Beans", 10, 15, 3, 5, "image");
                break;
            case BEET:
                return new PlantImpl("Beet", 10, 15, 3, 5, "image");
                break;
            case CARROT:
                return new PlantImpl("Carrot", 10, 15, 3, 5, "image");
                break;
            case CORN:
                return new PlantImpl("Corn", 10, 15, 3, 5, "image");
                break;
            case TOMATO:
                return new PlantImpl("Tomato", 10, 15, 3, 5, "image");    
                break;
            default:
                break;
        }
    }

    public static void setCurrentSeed(Type seed) {
        Seed.seed = seed;
    }
}

