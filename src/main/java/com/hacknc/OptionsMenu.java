package com.hacknc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsMenu implements ActionListener {
    private JPanel optionsMenu;
    private CardLayout cl;
    private JPanel card;

    public OptionsMenu(CardLayout _cl, JPanel _card) {
        cl = _cl;
        card = _card;
        optionsMenu = new JPanel();
        JButton resumeButton = new JButton("Resume Game");
        optionsMenu.add(resumeButton);
        resumeButton.addActionListener(this);
        resumeButton.setActionCommand("Resume");
        JButton exitButton = new JButton("Exit Game");
        optionsMenu.add(exitButton);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Resume".equals(e.getActionCommand()))
        {
            WindowManager.running = true;
            cl.previous(card);
        }else if("Exit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
    }

    public JPanel getOptionsMenu() 
    {
        return optionsMenu;
    }
}
