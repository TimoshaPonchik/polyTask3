package com.example.polytask3.classes;

import com.example.framework.CollisionDetect;
import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.utilits.UtilRandomFw;
import com.example.polytask3.mapLevelGenerator.GeneratorWallLevelOne;
import com.example.polytask3.mapLevelGenerator.GeneratorEnemyLevelOne;
import com.example.polytask3.objects.Enemy;
import com.example.polytask3.objects.HUD;
import com.example.polytask3.objects.MainPlayer;
import com.example.polytask3.objects.Wall;

public class GameManager {

    private int timePassed;
    private int currentHealth;
    private int currentX;
    private int currentY;
    MainPlayer mainPlayer;
    Wall wall;
    Enemy enemy;
    HUD hud;
    GeneratorWallLevelOne wallGeneratorLevelOne;
    GeneratorEnemyLevelOne enemyGeneratorLevelOne;

//статичная, чтобы можно было без создания объекта управлять этой переменной
    public static boolean gameOver;
    public static boolean gameWin;
    public GameManager(CoreFw coreFw, int sceneWidth, int sceneHeight) {
        hud = new HUD(coreFw);
        //класс выполняет логику всей игры, руководит всей игрой (коллизии, удары итд...)
        mainPlayer = new MainPlayer(coreFw, sceneWidth, sceneHeight, hud.getHEIGHT_HUD() * 2);
        wallGeneratorLevelOne = new GeneratorWallLevelOne(sceneWidth, sceneHeight);
        enemyGeneratorLevelOne = new GeneratorEnemyLevelOne(sceneWidth, sceneHeight);
        wall = new Wall(sceneWidth, sceneHeight, hud.getHEIGHT_HUD(), -100);
        enemy = new Enemy(sceneWidth, sceneHeight, hud.getHEIGHT_HUD(), -100, 0, coreFw);
        gameOver = false;
        gameWin = false;
        StringBuilder gameSeed = new StringBuilder();
        int roomSeed;
        for (int i = 0; i < 9; i++) {
            gameSeed.append(UtilRandomFw.getGap(1, 2));
        }
        roomSeed = UtilRandomFw.getGap(1, 4);
        GeneratorWallLevelOne.seedGame = gameSeed.toString();
        GeneratorEnemyLevelOne.seedGame = gameSeed.toString();
        GeneratorWallLevelOne.seedRoom = roomSeed;
    }

    public int getTimePassed() {
        return timePassed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void update() {
        mainPlayer.update();
        int getCurrentMovementX = mainPlayer.getCurrentMovementX();
        int getCurrentMovementY = mainPlayer.getCurrentMovementY();
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

    public void drawing(GraphicsFw graphicsFw) {
        mainPlayer.drawing(graphicsFw);
        wall.drawing(graphicsFw);
        enemy.drawing(graphicsFw);
        hud.drawing(graphicsFw);
        wallGeneratorLevelOne.drawing(graphicsFw);
        enemyGeneratorLevelOne.drawing(graphicsFw);
    }
}
