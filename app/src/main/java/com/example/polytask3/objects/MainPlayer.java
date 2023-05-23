package com.example.polytask3.objects;

import android.graphics.Rect;

import com.example.framework.CollisionDetect;
import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.framework.utilits.UtilTime;
import com.example.framework.utilits.UtilTimerDelay;
import com.example.polytask3.classes.GameManager;
import com.example.polytask3.mapLevelGenerator.GeneratorWallLevelOne;
import com.example.polytask3.utilits.UtilResource;
import com.example.framework.AnimationFw;

public class MainPlayer extends ObjectFw {
    final int MAX_SPEED = 8;
    AnimationFw animSpriteMainPlayer;
    AnimationFw animMainPlayerBoost;
    AnimationFw animMainPlayerDeath;
    CoreFw coreFw;

    boolean boosting;
    boolean hit;
    boolean movement = false;
    boolean gameOver = false;

    boolean lastUp;
    boolean lastDown;
    boolean lastLeft;
    boolean lastRight;
    boolean deathLoop;
    private static final int SWIPE_DISTANCE_THRESHOLD = 30;


    float[] getSwipesCoord = new float[2];
    //принимаем coreFw для обработки свайпа пользователем
    public int currentHealth;
    private int passedTime;
    public int currentMovementX = 0;
    public int currentMovementY = 0;
    UtilTimerDelay timerOnGameOver;
    UtilTime timeTimer;

    public MainPlayer(CoreFw coreFw, int maxScreenX, int maxScreenY, int minScreenY) {
        currentHealth = 3;
        speed = 0;
        x = 2 * 64;
        y = 3 * 64;
        boosting = false;
        radius = UtilResource.spritePlayer.get(0).getWidth() / 2;
        timerOnGameOver = new UtilTimerDelay();
        timeTimer = new UtilTime();
        this.coreFw = coreFw;
        this.maxScreenX = maxScreenX - UtilResource.spritePlayer.get(0).getWidth();
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        this.minScreenY = minScreenY - UtilResource.spritePlayer.get(0).getHeight();
        //загружаем в animSpriteMainPlayer 2 спрайта из arrayList spritePlayer
        animSpriteMainPlayer = new AnimationFw(1, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1));

        animMainPlayerBoost = new AnimationFw(1, UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(0));

        animMainPlayerDeath = new AnimationFw(1, UtilResource.spriteHitPlayer.get(0),
                UtilResource.spriteHitPlayer.get(1));
            timeTimer.startTime();
    }

    public void update() {
        passedTime = 1000 - timeTimer.timeDelay();
        if (!gameOver) {
            movement = speed != 0;
            coreFw.getTouchListenerFw().setMovement(movement);

            if (coreFw.getTouchListenerFw().getSwiped()) {
                startBoosting();
            }

            if (!movement) {
                getSwipesCoord = coreFw.getTouchListenerFw().swipeDir();
            }

            if (boosting) { //регулируем скорость
                speed += 8;
            } else speed = 0;

            if (Math.abs(getSwipesCoord[0]) > Math.abs(getSwipesCoord[1])) {
                if (getSwipesCoord[0] > SWIPE_DISTANCE_THRESHOLD) {
                    if (hit && lastLeft) {
                        stopBoosting();
                        x += CollisionDetect.collisionSub();
                    } else {
                        x -= speed;
                        lastLeft = true;
                        lastRight = false;
                    }

                } else if (getSwipesCoord[0] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                    if (hit && lastRight) {
                        stopBoosting();
                        x -= CollisionDetect.collisionSub();
                    } else {
                        x += speed;
                        lastLeft = false;
                        lastRight = true;
                    }
                }
            } else {
                if (getSwipesCoord[1] < -1 * SWIPE_DISTANCE_THRESHOLD) {
                    if (hit && lastDown) {
                        stopBoosting();
                        y -= CollisionDetect.collisionSub();
                    } else {
                        y += speed;
                        lastUp = false;
                        lastDown = true;
                    }
                } else if (getSwipesCoord[1] > SWIPE_DISTANCE_THRESHOLD) {
                    if (hit && lastUp) {
                        stopBoosting();
                        y += CollisionDetect.collisionSub();
                    } else {
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
                x = minScreenX;
                currentMovementX++;

            }
            if (x < minScreenX) {
                x = maxScreenX;
                currentMovementX--;
            }


            if (y < minScreenY) {
                y = maxScreenY;
                currentMovementY++;
            }
            if (y > maxScreenY) {
                y = minScreenY;
                currentMovementY--;
            }
        }
        hit = false;
        new GeneratorWallLevelOne(maxScreenX, maxScreenY, minScreenY);
        //запускаем анимацию
        if (gameOver) {
            animMainPlayerDeath.runAnimation();
        } else {
            if (boosting) {
                animMainPlayerBoost.runAnimation();
            } else animSpriteMainPlayer.runAnimation();
        }
        hitBox = new Rect(x, y, UtilResource.spritePlayer.get(0).getWidth(),
                UtilResource.spritePlayer.get(0).getHeight());
        deathLoop = true;
    }


    public int getCurrentMovementX() {
        return currentMovementX;
    }

    public int getCurrentMovementY() {
        return currentMovementY;
    }

    private void startBoosting() {
        boosting = true;
    }

    private void stopBoosting() {
        boosting = false;
    }

    public void drawing(GraphicsFw graphicsFw) {

        if (gameOver) {
            movement = false;
            animMainPlayerDeath.drawingAnimation(graphicsFw, x, y);
            if (timerOnGameOver.timerDelay(2)) {
                coreFw.getTouchListenerFw().setMovement(false);
                GameManager.gameOver = true;
            }
        } else {
            if (boosting) {
                animMainPlayerBoost.drawingAnimation(graphicsFw, x, y);
            } else {
                animSpriteMainPlayer.drawingAnimation(graphicsFw, x, y);
            }
        }
    }

    public int getPassedTime() {
        return passedTime;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void hitWall() {
        hit = true;
    }

    public void death() {
        if (deathLoop && currentHealth > 0) {
            deathLoop = false;
            currentHealth--;
            if (currentHealth > 0) {
                currentMovementX = 0;
                currentMovementY = 0;
                x = 2 * 64;
                y = 3 * 64;
                stopBoosting();
                movement = false;
            } else {
                gameOver = true;
                timerOnGameOver.startTimer();
            }
        }
    }
}
