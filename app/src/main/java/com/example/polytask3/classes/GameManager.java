package com.example.polytask3.classes;

import com.example.framework.CollisionDetect;
import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.mapLevelGenerator.GeneratorWallLevelOne;
import com.example.polytask3.mapLevelGenerator.GeneratorEnemyLevelOne;
import com.example.polytask3.objects.Enemy;
import com.example.polytask3.objects.HUD;
import com.example.polytask3.objects.MainPlayer;
import com.example.polytask3.objects.Wall;

public class GameManager {
    //класс выполняет логику всей игры, руководит всей игрой (коллизии, удары итд...)
    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    private int timePassed;
    private int currentHealth;
    private int getCurrentMovementX;
    private int getCurrentMovementY;
    private int currentX;
    private int currentY;
    private int[][] levelOneArrCoord;
    MainPlayer mainPlayer;
    Wall wall;
    Enemy enemy;
    HUD hud;
    GeneratorWallLevelOne wallGeneratorLevelOne;
    GeneratorEnemyLevelOne enemyGeneratorLevelOne;

//статичная, чтобы можно было без создания объекта управлять этой переменной
    public static boolean gameOver;
    public GameManager(CoreFw coreFw, int sceneWidth, int sceneHeight) {
        hud = new HUD(coreFw);
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenY = hud.getHEIGHT_HUD();
        minScreenX = 0;
        mainPlayer = new MainPlayer(coreFw, maxScreenX, maxScreenY, hud.getHEIGHT_HUD() * 2);
        wallGeneratorLevelOne = new GeneratorWallLevelOne(sceneWidth, sceneHeight, minScreenY);
        enemyGeneratorLevelOne = new GeneratorEnemyLevelOne(sceneWidth, sceneHeight, minScreenY);
        wall = new Wall(maxScreenX, maxScreenY, hud.getHEIGHT_HUD(), -100);
        enemy = new Enemy(maxScreenX, maxScreenY, hud.getHEIGHT_HUD(), -100, 0, coreFw);
        gameOver = false;
    }

    public void update() {
        mainPlayer.update();
        getCurrentMovementX = mainPlayer.getCurrentMovementX();
        getCurrentMovementY = mainPlayer.getCurrentMovementY();
        if (currentX != getCurrentMovementX || currentY != getCurrentMovementY) {
            currentX = getCurrentMovementX;
            currentY = getCurrentMovementY;
            wallGeneratorLevelOne.setCurrentX(currentX);
            enemyGeneratorLevelOne.setCurrentX(currentX);
            wallGeneratorLevelOne.setCurrentY(currentY);
            enemyGeneratorLevelOne.setCurrentY(currentY);
            wallGeneratorLevelOne.update(true);
            enemyGeneratorLevelOne.update(true);
        } else {
            wallGeneratorLevelOne.update(false);
            enemyGeneratorLevelOne.update(false);
        }
        wall.update();
        enemy.update();
        checkHit();
        timePassed = mainPlayer.getPassedTime();
        currentHealth = mainPlayer.getCurrentHealth();

        hud.update(timePassed, currentHealth);

    }

    private void checkHit() {
        for (int i = 0; i < wallGeneratorLevelOne.wallsArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(mainPlayer, wallGeneratorLevelOne.wallsArrayList.get(i))) {
                mainPlayer.hitWall();
            }
            for (int j = 0; j < enemyGeneratorLevelOne.enemyArrayList.size(); j++) {
                if (CollisionDetect.collisionDetect(enemyGeneratorLevelOne.enemyArrayList.get(j), wallGeneratorLevelOne.wallsArrayList.get(i))) {
                    enemyGeneratorLevelOne.enemyArrayList.get(j).hitWall();
                }

                if (CollisionDetect.collisionDetect(enemyGeneratorLevelOne.enemyArrayList.get(j), mainPlayer)) {
                    mainPlayer.death();
                }
            }

        }
    }

    public void drawing(CoreFw coreFw, GraphicsFw graphicsFw) {
        mainPlayer.drawing(graphicsFw);
        wall.drawing(graphicsFw);
        enemy.drawing(graphicsFw);
        hud.drawing(graphicsFw);
        wallGeneratorLevelOne.drawing(graphicsFw);
        enemyGeneratorLevelOne.drawing(graphicsFw);
    }
}
