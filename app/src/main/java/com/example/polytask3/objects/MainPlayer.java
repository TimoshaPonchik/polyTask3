package com.example.polytask3.objects;

import android.graphics.Rect;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.utilits.UtilResource;
import com.example.framework.AnimationFw;

public class MainPlayer extends ObjectFw {
    final int MAX_SPEED = 8;
    AnimationFw animSpriteMainPlayer;
    AnimationFw animMainPlayerBoost;
    CoreFw coreFw;

    boolean boosting;
    boolean hit;
    boolean movement = false;

    boolean lastUp;
    boolean lastDown;
    boolean lastLeft;
    boolean lastRight;
    private static final int SWIPE_DISTANCE_THRESHOLD = 100;


    float[] getSwipesCoord = new float[2];
    //принимаем coreFw для обработки свайпа пользователем
    public int currentHealth;
    private int coinsCollected;

    public MainPlayer(CoreFw coreFw, int maxScreenX, int maxScreenY, int minScreenY) {
        currentHealth = 3;
        coinsCollected = 0;
        speed = 0;
        x = (maxScreenX - UtilResource.spritePlayer.get(0).getWidth()) / 2;
        y = (maxScreenY - UtilResource.spritePlayer.get(0).getHeight()) / 2;
        boosting = false;

        radius = UtilResource.spritePlayer.get(0).getWidth() / 2;

        this.coreFw = coreFw;
        this.maxScreenX = maxScreenX - UtilResource.spritePlayer.get(0).getWidth();
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        this.minScreenY = minScreenY - UtilResource.spritePlayer.get(0).getHeight();
        //загружаем в animSpriteMainPlayer 2 спрайта из arrayList spritePlayer
        animSpriteMainPlayer = new AnimationFw(1, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1));

        animMainPlayerBoost = new AnimationFw(1, UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(0));
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
            speed += 8;
        } else speed = 0;

        if (Math.abs(getSwipesCoord[0]) > Math.abs(getSwipesCoord[1])) {
            if (getSwipesCoord[0] > SWIPE_DISTANCE_THRESHOLD) {
                if (hit && lastLeft) {
                    stopBoosting();
                } else {
                    startBoosting();
                    x -= speed;
                    lastLeft = true;
                    lastRight = false;
                }
            } else if (getSwipesCoord[0] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                if (hit && lastRight) {
                    stopBoosting();
                } else {
                    startBoosting();
                    x += speed;
                    lastLeft = false;
                    lastRight = true;
                }
            }
        } else {
            if (getSwipesCoord[1] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                if (hit && lastDown) {
                    stopBoosting();
                } else {
                    startBoosting();
                    y += speed;
                    lastUp = false;
                    lastDown = true;
                }
            } else if (getSwipesCoord[1] > SWIPE_DISTANCE_THRESHOLD) {
                if (hit && lastUp) {
                    stopBoosting();
                } else {
                    System.out.println(y);
                    startBoosting();
                    y -= speed;
                    lastUp = true;
                    lastDown = false;
                }
            }
        }

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (x > maxScreenX) {
            x = maxScreenX;
            stopBoosting();
        }
        if (x < minScreenX) {
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
        } else animSpriteMainPlayer.runAnimation();
        hitBox = new Rect(x, y, UtilResource.spritePlayer.get(0).getWidth(),
                UtilResource.spritePlayer.get(0).getHeight());
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

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void hitWall() {
        hit = true;
    }
}
