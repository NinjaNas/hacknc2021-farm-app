package com.hacknc;

import java.awt.event.*;

public interface Tile {
    //Sets the active plant on the tile
    public void setPlant(Plant plant);
    //Updates the fertilization value of the tile
    public void updateTile(long deltaTime);
}
