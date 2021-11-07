package com.hacknc;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.ImageIcon;

public class TileImpl implements Tile, ActionListener {
  private long fertilizationVal; // Represents the amount of nutrients that are held in the soil.
  private Plant plant; // Represents the active plant on the tile.
  private JButton tile; // Will be the button that acts as a tile
  private boolean isTilled; // Is true if the tile is empty, false if the tile is planted
  private boolean isPlanted;
  private int dim; // Represents the nxn dimensions of the tile
  private long fertChange; // Represents the change in the ferilization value per unit time.

  public TileImpl(int size) {
    dim = size;
    tile = new JButton();
    tile.setMargin(new Insets(0,0,0,0));
    tile.addActionListener(this);
    tile.setActionCommand("Click");
    fertilizationVal = 100;
    fertChange = 10;
    isPlanted = false;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Performs Action on Click
    try {
      plant = SeedImpl.plantSeed();
      System.out.println(plant);
      System.out.println(SeedImpl.imageHandler(plant));
      this.setIcon(SeedImpl.imageHandler(plant));
    } catch (IOException i) {
      System.out.println("q");
    }
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
  public void updateTile(long deltaTime) throws IOException {
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
      this.setIcon(SeedImpl.imageHandler(plant));
    } else if (!isPlanted && !isTilled) {
      fertilizationVal += fertChange * deltaTime;
    }
  }

  @Override
  public void setIcon(BufferedImage icon) {
    tile.setPreferredSize(new Dimension(tile.getWidth(),tile.getHeight()));
    Image tileIcon = icon.getScaledInstance(tile.getWidth(), tile.getHeight(), Image.SCALE_SMOOTH);
    tile.setIcon(new ImageIcon(tileIcon));
  }

@Override
public JButton getButton() {
    // TODO Auto-generated method stub
    return tile;
}
}
