package com.client.game;

import com.player.Bike;
import com.player.Player;
import com.terrain.Block;
import com.terrain.Level;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {
    Player player;
    Bike bike;
    Level level;
    Timer gameTimer;
    public ArrayList<Block> track = new ArrayList<>();

    int dfclty = 0;

    public GamePanel() {
        player = new Player(300, 10, this);
        bike = new Bike(player);
        level = new Level(dfclty, bike);
        makeTrack();
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set(bike);
                bike.set();
                repaint();
            }
        }, 0, 17);
    }

    // get graphics to be able to render the game pieces
    public void paint(Graphics g) {
        super.paint(g);

        // cast the graphics to Graphics2D
        Graphics2D gtd = (Graphics2D)g;
        player.draw(gtd);
        bike.draw(gtd);
        for(Block block: track) block.draw(gtd);
    }

    public void makeTrack(){
        // pass arguments to terrain to give it qualities
        for(int i = 100; i < 801; i+= 100) {
            track.add(new Block(i, 200, 100, 50));
        }
        // if(level 1) track.add(new Block(x, y, w, h)) make a pattern
        //  else set up the track set up track for level 2
        // switch statement for level # and ArrayList<> track = level.makeTrack()
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) player.spaceBar = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.keyRight = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.keyLeft = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.keyDown = true;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.keyUp = true;
        if(e.getKeyCode() == KeyEvent.VK_A) player.keyA = true;
        if(e.getKeyCode() == KeyEvent.VK_W) player.keyW = true;
        if(e.getKeyCode() == KeyEvent.VK_S) player.keyS = true;
        if(e.getKeyCode() == KeyEvent.VK_D) player.keyD = true;
        if(e.getKeyCode() == KeyEvent.VK_PERIOD) player.keyPeriod = true;
        if(e.getKeyCode() == KeyEvent.VK_SLASH) player.keySlash = true;
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) player.spaceBar = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) player.keyRight = false;
        if(e.getKeyCode() == KeyEvent.VK_LEFT) player.keyLeft = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN) player.keyDown = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) player.keyUp = false;
        if(e.getKeyCode() == KeyEvent.VK_A) player.keyA = false;
        if(e.getKeyCode() == KeyEvent.VK_W) player.keyW = false;
        if(e.getKeyCode() == KeyEvent.VK_S) player.keyS = false;
        if(e.getKeyCode() == KeyEvent.VK_D) player.keyD = false;
        if(e.getKeyCode() == KeyEvent.VK_PERIOD) player.keyPeriod = false;
        if(e.getKeyCode() == KeyEvent.VK_SLASH) player.keySlash = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
