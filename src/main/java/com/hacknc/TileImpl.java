package com.hacknc;

import java.awt.event.*;
import javax.swing.JButton;

public class TileImpl implements Tile, ActionListener  {
    private long fertilizationVal; //Represents the amount of nutrients that are held in the soil.
    private Plant plant; //Represents the active plant on the tile.
    private JButton tile; //Will be the button that acts as a tile
    private boolean isEmpty; //Is true if the tile is empty, false if the tile is planted
    private int dim; //Represents the nxn dimensions of the tile
    private long fertChange; //Represents the change in the ferilization value per unit time.


    public TileImpl(int x, int y, int size)
    {
        dim = size;
        tile = new JButton();
        tile.setBounds(x, y, size, size);
        tile.addActionListener(this);
        tile.setActionCommand("Click");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Performs Action on Click
        if(isEmpty)
        {
            plant = Seed.plantSeed();
            isEmpty = false;
        }
    }

    @Override
    public void setPlant(Plant plant) {
        // TODO Auto-generated method stub
        if(isEmpty)
        {
            plant = Seed.plantSeed;
            isEmpty = false;
        }else
        {
            plant.harvest();
        }
    }

    @Override
    public void updateTile(long deltaTime) {
        // TODO Auto-generated method stub
        plant.updatePlant(deltaTime);
    }
}
