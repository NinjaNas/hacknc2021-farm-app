package com.hacknc;

import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JButton;

public interface Tile {
    //Sets the active plant on the tile
    public void setPlant(Plant plant);

    //Updates the fertilization value of the tile
    public void updateTile(double deltaTime) throws IOException;

    //Sets the image of the tile
    public void setIcon(BufferedImage icon);

    //Sets the image of the tile
    public void setSuperImposedIcon(BufferedImage fg, BufferedImage bg);

    //Code for the action that the tile will take when clicked on
    public void actionPerformed(ActionEvent e);

    //Returns the JButton associated with the tile.
    public JButton getButton();
}
