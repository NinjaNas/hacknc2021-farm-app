package com.hacknc;

import javax.swing.*;

public class Frame {
    private static JFrame _JFrame;

    public static JFrame create() {
        if (_JFrame == null) {
            _JFrame = new JFrame();
        }
        return _JFrame;
    }
}
