package com.hacknc;

import javax.swing.JButton;
import java.awt.event.*;

public class MenuButtonImpl implements MenuButton, ActionListener {

    JButton menuButton;
    Seed.Type type;

    public MenuButtonImpl(String name, Seed.Type _type) {
        menuButton = new JButton(name);
        type = _type;
        menuButton.addActionListener(this);
        menuButton.setActionCommand("Set Seed");
    }

    @Override
    public JButton getButton() {
        // TODO Auto-generated method stub
        return menuButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        SeedImpl.setSeed(type);
    }

}
