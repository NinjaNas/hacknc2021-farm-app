package com.hacknc;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FarmMapImpl implements FarmMap {
    private Tile[][] map;
    private JPanel mapPanel;
    public FarmMapImpl(int n, int m, int size)
    {
        
        mapPanel = new JPanel();
        mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.Y_AXIS));
        map = new Tile[n][m];

        for (int i = 0; i < n; i++)
        {
            JPanel mapRow = new JPanel();
            mapRow.setLayout(new GridLayout(0,m));

            for(int j = 0; j < m; j++)
            {
                Tile tileToAdd = new TileImpl(size);
                mapRow.add(tileToAdd.getButton());
                map[i][j] = tileToAdd;
            }
            mapPanel.add(mapRow);
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