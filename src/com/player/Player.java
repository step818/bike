package com.player;

import com.client.game.GamePanel;

import java.awt.*;

public class Player {

    GamePanel panel;
    int x;
    int y;
    int width;
    int height;

    double xspeed;
    double yspeed;
    double pump;

    Rectangle hitDummy;

    // player has a set of skills being implemented or not
    public boolean spaceBar;

    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyUp;
    public boolean keyDown;

    public boolean keyW;
    public boolean keyA;
    public boolean keyS;
    public boolean keyD;

    public boolean keyPeriod;
    public boolean keySlash;

    public Player(int x, int y, GamePanel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 25;
        height = 50;
        hitDummy = new Rectangle(x, y, width, height);
    }

    public void set() {
        // controls response
        if(!spaceBar) {
          xspeed *= 0.5;
          yspeed *= 0.5;
          pump = 0;
        } else if(spaceBar) pump = 4;

        // gravity
        yspeed = pump + 5;

        x = (int) (x + xspeed);
        y = (int) (y + yspeed);

        hitDummy.x = x;
        hitDummy.y = y;
    }

    // render the player with color
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.blue);
        gtd.fillRect(x, y, width, height);
    }
}
