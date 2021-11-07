package com.hacknc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends App implements ActionListener {
    private boolean _start;
    private JPanel mainMenu;

    public MainMenu() {
        _start = false;
        mainMenu = new JPanel();
        JButton button = new JButton("Start game button");
        mainMenu.add(button);
        button.addActionListener(this);
        button.setActionCommand("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _start = true;
    }

    public boolean getStart() {
        return _start;
    }

    public JPanel getMainMenu() 
    {
        return mainMenu;
    }
}
