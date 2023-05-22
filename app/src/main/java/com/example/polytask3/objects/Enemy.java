package com.example.polytask3.objects;

import android.graphics.Rect;
import android.widget.Switch;

import com.example.framework.AnimationFw;
import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.utilits.UtilResource;

public class Enemy extends ObjectFw {


    AnimationFw animEnemy;
    boolean hit;
    CoreFw coreFw;
    boolean direction;
    boolean typeLeft;
    boolean typeUp;

    public Enemy(int maxScreenX, int maxScreenY, int y, int x, int enemyType, CoreFw coreFw) {
        this.maxScreenX = maxScreenX - UtilResource.spriteEnemy.get(0).getWidth();
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.coreFw = coreFw;
        animEnemy = new AnimationFw(1, UtilResource.spriteEnemy.get(0), UtilResource.spriteEnemy.get(1));
        this.x = x;
        this.y = y;
        radius = UtilResource.spriteEnemy.get(0).getWidth() / 2;
        speed = 0;

        switch (enemyType) {
            case (1):
                setTypeLeft(true);
                setTypeUp(false);
                break;
            case (2):
                setTypeLeft(false);
                setTypeUp(true);
                break;
            default:
                break;
        }
    }

    public void update() {
        if (hit) {
            direction = !direction;
        }

        if (direction) {
            speed = 2;
        } else {
            speed = -2;
        }

        if (typeLeft) {
            x += speed;
        }

        if (typeUp) {
            y += speed;
        }
        hit = false;
        animEnemy.runAnimation();
        hitBox = new Rect(x, y, UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing(GraphicsFw graphicsFw) {
        animEnemy.drawingAnimation(graphicsFw, x, y);
    }

    public void setTypeLeft(boolean typeLeft) {
        this.typeLeft = typeLeft;
    }

    public void setTypeUp(boolean typeUp) {
        this.typeUp = typeUp;
    }

    public void hitWall() {
        hit = true;
    }
}

