package com.hacknc;

public interface Seed {
    void setCurrentSeed(Type seed);

    // The type of seeds
    enum Type {
        WHEAT(10),
        CARROT(15),
        BEET(10),
        POTATO(10),
        BERRIES(10);

        public final int cost;

        private Type(int cost){
          this.cost = cost;
        }
    }
}
