package com.hacknc;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;

public class TileImpl implements Tile, ActionListener {
  private long fertilizationVal; // Represents the amount of nutrients that are held in the soil.
  private Plant plant; // Represents the active plant on the tile.
  private JButton tile; // Will be the button that acts as a tile
  private boolean isTilled; // Is true if the tile is empty, false if the tile is planted
  private boolean isPlanted;
  private int dim; // Represents the nxn dimensions of the tile
  private long fertChange; // Represents the change in the ferilization value per unit time.

  public TileImpl(int x, int y, int size) {
    dim = size;
    tile = new JButton();
    tile.setBounds(x, y, dim, dim);
    tile.addActionListener(this);
    tile.setActionCommand("Click");
    fertilizationVal = 100;
    fertChange = 10;
    isPlanted = false;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Performs Action on Click
    if (isTilled) {
      plant = SeedImpl.plantSeed();
      isTilled = false;
      isPlanted = true;
    }
    if (isPlanted) {
      plant.getYield();
      plant = null;
      isPlanted = false;
    }
  }

  @Override
  public void setPlant(Plant _plant) {
    // TODO Auto-generated method stub
    plant = _plant;
  }

  @Override
  public void updateTile(long deltaTime) {
    // TODO Auto-generated method stub
    if (isPlanted) {
      long nutriChange;
      if (deltaTime * plant.getNutrientIn() > fertilizationVal) {
        nutriChange = fertilizationVal;
        fertilizationVal = 0;
      } else {
        nutriChange = plant.getNutrientIn() * deltaTime;
        fertilizationVal = -plant.getNutrientIn() * deltaTime;
      }
      plant.update(deltaTime, nutriChange);
    } else if (!isPlanted && !isTilled) {
      fertilizationVal += fertChange * deltaTime;
    }
  }

  @Override
  public void setIcon(BufferedImage icon) {
    Image tileIcon = icon.getScaledInstance(dim, dim, Image.SCALE_SMOOTH);
    tile.setIcon(new ImageIcon(tileIcon));
  }

@Override
public JButton getButton() {
    // TODO Auto-generated method stub
    return tile;
}
}
