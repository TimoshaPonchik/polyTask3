package com.example.polytask3.objects;

import com.example.framework.AnimationFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.utilits.UtilResource;

public class Wall extends ObjectFw {

    AnimationFw animWall;

    public Wall(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX - UtilResource.spriteWall.get(0).getWidth();
        this.maxScreenY = maxScreenY - UtilResource.spriteWall.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        animWall = new AnimationFw(1, UtilResource.spriteWall.get(0), UtilResource.spritePlayer.get(0));
        x = maxScreenX - 20;
        y = maxScreenY / 2 - 20;
        speed = 0;
    }

    public void update() {
        animWall.runAnimation();
    }

    public void drawing(GraphicsFw graphicsFw) {
        animWall.drawingAnimation(graphicsFw, x, y);
    }
}
