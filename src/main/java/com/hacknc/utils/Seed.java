package com.hacknc.utils;

enum Type {
    WHEAT,
    CORN,
    BEANS,
    CARROT,
    BEET,
    TOMOTO;
}

public final class Seed {
    static Type seed;

    public Seed(Type seed) {
        Seed.seed = seed;
    }
    public static void plantSeed() {
        switch (seed) {
            case WHEAT:
                break;
            case BEANS:
                break;
            case BEET:
                break;
            case CARROT:
                break;
            case CORN:
                break;
            case TOMOTO:
                break;
            default:
                break;
        }
    }

    public static void setCurrentSeed(Type seed) {
        Seed.seed = seed;
    }
}

