package com.player;

import com.client.MainFrame;
import com.client.game.GamePanel;
import com.terrain.Block;

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

    public void set(Bike bike) {
        // controls response
        //spacebar
        //TODO: get creative and make a downwards slope to slide down, spacebar functionality might change
        if(!spaceBar) {
          xspeed *= 0.5;
          yspeed *= 0.5;
          pump = 0;
        } else if(spaceBar) {
            pump = 2;
        }

        // gravity
        yspeed = pump + 5;
        xspeed = (pump/2);

        // horizontal collisions
        hitDummy.x += xspeed;
        for(Block block: panel.track){
            if(bike.hitBike.intersects(block.hitGround)){
                bike.hitBike.x -= xspeed;
                hitDummy.x -= xspeed;
                while(!block.hitGround.intersects(bike.hitBike)){
                    bike.hitBike.x += Math.signum(xspeed);
                    hitDummy.x += Math.signum(xspeed);
                }
                bike.hitBike.x -= Math.signum(xspeed);
                hitDummy.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitDummy.x;
            }
        }

        // vertical collisions
        hitDummy.y += yspeed;
        for(Block block: panel.track){
            if(bike.hitBike.intersects(block.hitGround)){
                bike.hitBike.y -= yspeed;
                hitDummy.y -= yspeed;
                while(!block.hitGround.intersects(bike.hitBike)){
                    bike.hitBike.y += Math.signum(yspeed);
                    hitDummy.y += Math.signum(yspeed);
                }
                bike.hitBike.y -= Math.signum(yspeed);
                hitDummy.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitDummy.y;
            }
        }


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
