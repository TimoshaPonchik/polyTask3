package com.example.polytask3.objects;

import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.framework.utilits.UtilResource;
import com.example.polytask3.classes.AnimationGame;

public class MainPlayer extends ObjectFw {
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationGame animSpriteMainPlayer;

    public MainPlayer(int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 100;
        speed = 1;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        //загружаем в animSpriteMainPlayer 4 спрайта из arrayList spritePlayer
        animSpriteMainPlayer = new AnimationGame(speed, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
    }

    public void update() {
        y -= speed;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenX) {
            y = maxScreenY;
        }
        //запускаем анимацию
        animSpriteMainPlayer.runAnimation();
    }

    public void drawing(GraphicsFw graphicsFw) {
        animSpriteMainPlayer.drawingAnimation(graphicsFw, x, y);
    }
}
