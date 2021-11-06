package com.hacknc;

import java.awt.image.BufferedImage;

public interface Tile {
    //Sets the active plant on the tile
    public void setPlant(Plant plant);
    //Updates the fertilization value of the tile
    public void updateTile(long deltaTime);
    //Sets the image of the tile
    public void setIcon(BufferedImage icon);
}
