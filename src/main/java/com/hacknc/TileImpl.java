package com.hacknc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;

public class TileImpl implements Tile, ActionListener {
    private double fertilizationVal; // Represents the amount of nutrients that are held in the soil.
    private Plant plant; // Represents the active plant on the tile.
    private JButton tile; // Will be the button that acts as a tile
    private boolean isTilled; // Is true if the tile is empty, false if the tile is planted
    private boolean isPlanted;
    private double fertChange; // Represents the change in the ferilization value per unit time.

    public TileImpl() {
        tile = new JButton();
        tile.setMargin(new Insets(0, 0, 0, 0));
        tile.addActionListener(this);
        tile.setActionCommand("Click");
        fertilizationVal = 100;
        fertChange = 10;
        isPlanted = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Performs Action on Click
        
        if (!isPlanted && !MenuBarImpl.tillEnabled && isTilled) {
            plant = SeedImpl.plantSeed();
            //isTilled = false;
            try {
              plant = SeedImpl.plantSeed();
              this.setIcon(SeedImpl.imageHandler(plant));
            } catch (IOException i) {
              System.out.println("q");
            }
            isPlanted = true;
        }else if (!isPlanted && MenuBarImpl.tillEnabled && !isTilled) {
            isTilled = true;
        }else if(isPlanted && !MenuBarImpl.tillEnabled)
        {
            plant.getYield();
            plant = null;
            isPlanted = false;
            isTilled = false;
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
        if(isPlanted) {
            double nutriChange;
            if (deltaTime * plant.getNutrientIn() > fertilizationVal) {
                nutriChange = fertilizationVal;
                fertilizationVal = 0;
            } else {
                nutriChange = plant.getNutrientIn() * deltaTime;
                fertilizationVal += -plant.getNutrientIn() * deltaTime;
            }
            plant.update(deltaTime, nutriChange);
            System.out.println(fertilizationVal);
            this.setSuperImposedIcon(SeedImpl.imageHandler(plant), Soil.getSoilIcon(isTilled,fertilizationVal));
        } else if(!isPlanted) {
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
            this.setIcon(Soil.getSoilIcon(isTilled,fertilizationVal));
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
