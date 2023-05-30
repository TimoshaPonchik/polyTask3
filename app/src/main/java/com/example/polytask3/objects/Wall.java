package com.example.polytask3.objects;

import android.graphics.Rect;

import com.example.framework.AnimationFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.utilits.UtilResource;

public class Wall extends ObjectFw {

    AnimationFw animWall;

    public Wall(int maxScreenX, int maxScreenY, int y, int x) {
            this.maxScreenX = maxScreenX - UtilResource.spriteWall.get(0).getWidth();
            this.maxScreenY = maxScreenY - UtilResource.spriteWall.get(0).getHeight();
        animWall = new AnimationFw(1, UtilResource.spriteWall.get(0), UtilResource.spriteWall.get(0));
        //x = maxScreenX - UtilResource.spritePlayer.get(0).getWidth();
        //y = (maxScreenY - UtilResource.spritePlayer.get(0).getHeight()) / 2;
        this.x = x;
        this.y = y;
        radius = UtilResource.spriteWall.get(0).getWidth() / 2;
        speed = 0;
        hitBox = new Rect(x, y, UtilResource.spriteWall.get(0).getWidth(),
                UtilResource.spriteWall.get(0).getHeight());
    }

    public void update() {
        animWall.runAnimation();
    }

    public void drawing(GraphicsFw graphicsFw) {
        animWall.drawingAnimation(graphicsFw, x, y);
    }
}
