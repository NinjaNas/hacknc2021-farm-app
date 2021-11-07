package com.hacknc;

import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FarmMapImpl implements FarmMap {
    private Tile[][] map;
    private JPanel mapPanel;
    public FarmMapImpl(int n, int m, int size)
    {
        
        mapPanel = new JPanel();
        GridLayout horizontal = new GridLayout(n,0,0,0);
        horizontal.setHgap(0);
        horizontal.setVgap(0);
        GridLayout vertical = new GridLayout(0,m,0,0);
        vertical.setHgap(0);
        vertical.setVgap(0);
        mapPanel.setLayout(horizontal);
        map = new Tile[n][m];

        for (int i = 0; i < n; i++)
        {
            JPanel mapRow = new JPanel();
            mapRow.setLayout(vertical);

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
    public void update(long deltaTime) throws IOException {
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