package com.hacknc;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.event.*;

public class FarmMapImpl implements FarmMap, ActionListener {
    private Tile[][] map;
    private JPanel mapPanel;

    public FarmMapImpl(int n, int m) {
        mapPanel = new JPanel();
        mapPanel.setBackground(new Color(102, 51, 0));
        GridLayout horizontal = new GridLayout(n, 0, 0, 0);
        horizontal.setHgap(0);
        horizontal.setVgap(0);
        GridLayout vertical = new GridLayout(0, m, 0, 0);
        vertical.setHgap(0);
        vertical.setVgap(0);
        mapPanel.setLayout(horizontal);
        map = new Tile[n][m];

        for (int i = 0; i < n; i++) {
            JPanel mapRow = new JPanel();
            mapRow.setLayout(vertical);
            mapRow.setBackground(new Color(102, 51, 0));

            for (int j = 0; j < m; j++) {
                Tile tileToAdd = new TileImpl();
                mapRow.add(tileToAdd.getButton());
                map[i][j] = tileToAdd;
                tileToAdd.getButton().addActionListener(this);
                tileToAdd.getButton().setActionCommand(Integer.toString(i)+Integer.toString(j));
            }
            mapPanel.add(mapRow);
        }
    }

    @Override
    public void update(double deltaTime) throws IOException {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        int i =Integer.parseInt( e.getActionCommand().substring(0,1));
        int j =Integer.parseInt( e.getActionCommand().substring(1,2));
        map[i][j].onClick();        
    }
}