package com.client;

import com.client.game.GamePanel;
import com.player.controls.KeyChecker;

import java.awt.*;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);

        // attach the KeyChecker here on the MainFrame and give the GamePanel to it
        addKeyListener(new KeyChecker(panel));
    }


}
