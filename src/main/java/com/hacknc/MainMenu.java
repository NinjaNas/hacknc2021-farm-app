package com.hacknc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends App implements ActionListener {
    private static MainMenu _main;
    private boolean _start;

    public MainMenu() {
        _start = false;
        JPanel menu = new JPanel();
        JButton button = new JButton("Start game button");
        menu.add(button);
        button.addActionListener(this);
        button.setActionCommand("");
        Frame.create().add(menu);
    }

    public static MainMenu create() {
        if (_main == null) {
            _main = new MainMenu();
        }
        return _main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _start = true;
    }

    public boolean getStart() {
        return _start;
    }

}
