package com.hacknc;

import javax.swing.JPanel;

public class FarmMapImpl implements FarmMap {
    private Tile[][] map;
    private JPanel mapPanel;
    public FarmMapImpl(int n, int m, int size)
    {
        
        mapPanel = new JPanel();
        mapPanel.setLayout(null);
        map = new Tile[n][m];

        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                Tile tileToAdd = new TileImpl(i*size,j*size,size);
                mapPanel.add(tileToAdd.getButton());
                map[i][j] = tileToAdd;
            }
        }
    }

    @Override
    public void update(long deltaTime) {
        // TODO Auto-generated method stub
        for (Tile[] tiles : map) {
            for (Tile tile : tiles) {
                tile.updateTile(deltaTime);
            }
        }
    }

    @Override
    public JPanel getMap() {
        // TODO Auto-generated method stub
        return mapPanel;
    }
}