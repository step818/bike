package com.player;

import java.awt.*;

public class Bike {
    int x;
    int y;
    int width;
    int height;

    double xspeed;
    double yspeed;
    double pump;

    Player player;
    Rectangle hitBike;

    public Bike(Player player){
        this.player = player;
        // connect the bike to the player
        x = player.x - player.width/2;
        y = player.y + player.height;

        width = 50;
        height = 25;
        hitBike = new Rectangle(x, y, width, height);
    }

    public void set(){
        // where the player goes, the bike goes too
        x = player.x - player.width/2;
        y = player.y + player.height;

        hitBike.x = x;
        hitBike.y = y;
    }

    // render the player with color
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.black);
        gtd.fillRect(x, y, width, height);
    }
}
