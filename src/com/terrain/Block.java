package com.terrain;

import java.awt.*;

public class Block {

    int x;
    int y;
    int height;
    int width;

    public Rectangle hitGround;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitGround = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.green);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.darkGray);
        gtd.fillRect(x+1, y+1, width-2, height-2);
    }
}
