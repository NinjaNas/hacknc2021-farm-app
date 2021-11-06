package com.hacknc.utils;

// The type of seeds
enum Type {
    WHEAT,
    CORN,
    BEANS,
    CARROT,
    BEET,
    TOMATO;
}

public final class Seed {
    static Type _seed;

    // Set the seed Type
    public Seed(Type seed) {
        _seed = seed;
    }
    // TODO(Isidro, Khang): balance all the plants
    // Create PlantImpl
    public static PlantImpl plantSeed() {
        switch (_seed) {
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
            // NOTE: make it return an error?
            default:
                break;
        }
    }

    // Change the seed Type
    // NOTE: Why is this method here isn't seed supposed to be static?
    public static void setCurrentSeed(Type seed) {
        _seed = seed;
    }
}

