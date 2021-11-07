package com.hacknc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileImpl implements Tile, ActionListener {
    private double fertilizationVal; // Represents the amount of nutrients that are held in the soil.
    private Plant plant; // Represents the active plant on the tile.
    private JButton tile; // Will be the button that acts as a tile
    private boolean isTilled; // Is true if the tile is empty, false if the tile is planted
    private boolean isPlanted;
    private double fertChange; // Represents the change in the fertilization value per unit time.

    public TileImpl() {
        tile = new JButton();
        tile.setMargin(new Insets(0, 0, 0, 0));
        tile.addActionListener(this);
        tile.setActionCommand("Click");
        fertilizationVal = 100;
        fertChange = 5;
        isPlanted = false;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        tile.setBorder(emptyBorder);
        tile.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Border border = BorderFactory.createLineBorder(Color.white, 2);
                tile.setBorder(border);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Border emptyBorder = BorderFactory.createEmptyBorder();
                tile.setBorder(emptyBorder);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Performs Action on Click

        if (!isPlanted && !MenuBarImpl.tillEnabled && isTilled && !MenuBarImpl.fertEnabled) {
            plant = SeedImpl.plantSeed();
            if(plant.getCost() > MenuBarImpl.money)
            {
              plant = null;
            }else
            {
              //isTilled = false;
              try {
                plant = SeedImpl.plantSeed();
                this.setIcon(SeedImpl.imageHandler(plant));
              } catch (IOException i) {

              }
              MenuBarImpl.money -= plant.getCost();
              isPlanted = true;
            }
        }else if (!isPlanted && MenuBarImpl.tillEnabled && !isTilled) {
            isTilled = true;
        }else if(isPlanted && !MenuBarImpl.tillEnabled && !MenuBarImpl.fertEnabled)
        {
            MenuBarImpl.money += plant.getYield();
            plant = null;
            isPlanted = false;
            isTilled = false;
        }else if(MenuBarImpl.fertEnabled)
        {
            if(!((MenuBarImpl.money - MenuBarImpl.fertCost) < 0))
            {
                if(fertilizationVal + MenuBarImpl.fertIncrease > 100)
                {
                    double diff = 100 - fertilizationVal;
                    fertilizationVal = 100;
                    MenuBarImpl.money -= MenuBarImpl.fertCost*diff/MenuBarImpl.fertIncrease;
                }else
                {
                    fertilizationVal += MenuBarImpl.fertIncrease;
                    MenuBarImpl.money -= MenuBarImpl.fertCost;
                }
            }
        }
    }

    @Override
    public void setPlant(Plant _plant) {
        // TODO Auto-generated method stub
        plant = _plant;
    }

    @Override
    public void updateTile(double deltaTime) throws IOException {
        // TODO Auto-generated method stub
        BufferedImage soil = Soil.getSoilIcon(isTilled,fertilizationVal);
        if(isPlanted) {
            double nutriChange;
            double nutriNeeded = deltaTime * plant.getNutrientIn();
            if (nutriNeeded > fertilizationVal) {
                nutriChange = fertilizationVal;
                fertilizationVal = 0;
            } else {
                nutriChange = nutriNeeded;
                fertilizationVal -= nutriNeeded;
            }
            plant.update(deltaTime, nutriChange);

            this.setSuperImposedIcon(SeedImpl.imageHandler(plant), soil);
        } else {
            if(!isTilled)
            {
                if(fertilizationVal + fertChange * deltaTime > 100)
                {
                  fertilizationVal = 100;
                }else
                {
                  fertilizationVal += fertChange * deltaTime;
                }
            }
            this.setIcon(soil);
        }
    }

    @Override
    public void setIcon(BufferedImage icon) {
        tile.setPreferredSize(new Dimension(tile.getWidth(), tile.getHeight()));
        Image tileIcon = icon.getScaledInstance(tile.getWidth(), tile.getHeight(), Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(tileIcon));
    }

    @Override
    public void setSuperImposedIcon(BufferedImage fg, BufferedImage bg) {
        BufferedImage combined = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = combined.getGraphics();
        g.drawImage(bg, 0, 0, null);
        g.drawImage(fg, 0, 0, null);
        g.dispose();
        tile.setPreferredSize(new Dimension(tile.getWidth(), tile.getHeight()));
        Image tileIcon = combined.getScaledInstance(tile.getWidth(), tile.getHeight(), Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(tileIcon));
    }

    @Override
    public JButton getButton() {
        // TODO Auto-generated method stub
        return tile;
    }
}
