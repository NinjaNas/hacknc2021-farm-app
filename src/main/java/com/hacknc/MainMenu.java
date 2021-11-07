package com.hacknc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends App implements ActionListener {
    private JPanel mainMenu;
    private CardLayout cl;
    private JPanel card;

    public MainMenu(CardLayout _cl, JPanel _card) {
        cl = _cl;
        card = _card;
        mainMenu = new JPanel();
        JButton button = new JButton("Start game button");
        mainMenu.add(button);
        button.addActionListener(this);
        button.setActionCommand("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cl.next(card);
        WindowManager.running = true;
    }

    public JPanel getMainMenu() 
    {
        return mainMenu;
    }
}
