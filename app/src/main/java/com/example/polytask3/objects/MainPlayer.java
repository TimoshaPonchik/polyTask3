package com.example.polytask3.objects;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.utilits.UtilResource;
import com.example.framework.AnimationFw;

import java.util.Arrays;

public class MainPlayer extends ObjectFw {
    final int MAX_SPEED = 30;
    AnimationFw animSpriteMainPlayer;
    AnimationFw animMainPlayerBoost;
    CoreFw coreFw;

    boolean boosting;
    boolean movement = false;

    private static final int SWIPE_DISTANCE_THRESHOLD = 100;


    float[] getSwipesCoord = new float[2];

    //принимаем coreFw для обработки свайпа пользователем
    public MainPlayer(CoreFw coreFw, int maxScreenX, int maxScreenY, int minScreenY) {
        x = (maxScreenX - UtilResource.spritePlayer.get(0).getWidth()) / 2;
        y = (maxScreenY - UtilResource.spritePlayer.get(0).getHeight()) / 2;
        speed = 0;
        boosting = false;
        this.coreFw = coreFw;
        this.maxScreenX = maxScreenX - UtilResource.spritePlayer.get(0).getWidth();
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        //загружаем в animSpriteMainPlayer 2 спрайта из arrayList spritePlayer
        animSpriteMainPlayer = new AnimationFw(1, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1));

        animMainPlayerBoost = new AnimationFw(1, UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayer.get(1));
    }

    public void update() {

        if (speed != 0) {
            movement = true;
        } else movement = false;

        if (coreFw.getTouchListenerFw().getSwiped()) {
            startBoosting();
        } //else if () {
        //startBoosting();
        //}
        if (!movement)
            getSwipesCoord = coreFw.getTouchListenerFw().swipeDir();

        if (boosting) { //регулируем скорость
            speed += 10;
        } else speed = 0;

        if (Math.abs(getSwipesCoord[0]) > Math.abs(getSwipesCoord[1])) {
            if (getSwipesCoord[0] > SWIPE_DISTANCE_THRESHOLD) {
                x -= speed;
            } else if (getSwipesCoord[0] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                x += speed;
            }
        } else {
            if (getSwipesCoord[1] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                y += speed;
            } else if (getSwipesCoord[1] > SWIPE_DISTANCE_THRESHOLD) {
                y -= speed;
            }
        }

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (x > maxScreenX) {
            x = maxScreenX;
            stopBoosting();
        }
        if (x < minScreenY) {
            x = minScreenX;
            stopBoosting();
        }


        if (y < minScreenY) {
            y = minScreenY;
            stopBoosting();
        }
        if (y > maxScreenY) {
            y = maxScreenY;
            stopBoosting();
        }
        //запускаем анимацию
        if (boosting) {
            animMainPlayerBoost.runAnimation();
        } else {
            animSpriteMainPlayer.runAnimation();
        }
    }

    private void startBoosting() {
        boosting = true;
    }

    private void stopBoosting() {
        boosting = false;
    }

    public void drawing(GraphicsFw graphicsFw) {
        if (boosting) {
            animMainPlayerBoost.drawingAnimation(graphicsFw, x, y);
        } else {
            animSpriteMainPlayer.drawingAnimation(graphicsFw, x, y);
        }
    }
}
