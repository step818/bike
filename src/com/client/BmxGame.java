package com.client;

import javax.swing.*;
import java.awt.*;

public class BmxGame {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        frame.setSize(1000, 700);

        // set the position of the frame with respect to screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));

        frame.setResizable(false);
        frame.setTitle("Bike");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
