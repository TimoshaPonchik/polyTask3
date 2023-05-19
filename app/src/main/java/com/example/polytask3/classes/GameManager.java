package com.example.polytask3.classes;

import com.example.framework.CollisionDetect;
import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.mapLevelGenerator.GeneratorLevelOne;
import com.example.polytask3.objects.HUD;
import com.example.polytask3.objects.MainPlayer;
import com.example.polytask3.objects.Wall;

public class GameManager {
    //класс выполняет логику всей игры, руководит всей игрой (коллизии, удары итд...)
    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    private int coinsCollected;
    private int currentHealth;
    private int getCurrentMovementX;
    private int getCurrentMovementY;
    private int currentX;
    private int currentY;
    MainPlayer mainPlayer;
    Wall wall;
    HUD hud;
    GeneratorLevelOne generatorLevelOne;

    public GameManager(CoreFw coreFw, int sceneWidth, int sceneHeight) {
        hud = new HUD(coreFw);
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenY = hud.getHEIGHT_HUD();
        minScreenX = 0;
        mainPlayer = new MainPlayer(coreFw, maxScreenX, maxScreenY, hud.getHEIGHT_HUD() * 2);

        generatorLevelOne = new GeneratorLevelOne(sceneWidth, sceneHeight, minScreenY);
        wall = new Wall(maxScreenX, maxScreenY, hud.getHEIGHT_HUD(), -100);
    }

    public void update() {
        mainPlayer.update();
        getCurrentMovementX = mainPlayer.getCurrentMovementX();
        getCurrentMovementY = mainPlayer.getCurrentMovementY();
        if (currentX != getCurrentMovementX || currentY != getCurrentMovementY) {
            currentX = getCurrentMovementX;
            currentY = getCurrentMovementY;
            generatorLevelOne.setCurrentX(currentX);
            generatorLevelOne.setCurrentY(currentY);
            generatorLevelOne.update(true);
        } else {
            generatorLevelOne.update(false);
        }
        wall.update();
        coinsCollected = mainPlayer.getCoinsCollected();
        currentHealth = mainPlayer.getCurrentHealth();

        hud.update(coinsCollected, currentHealth);

        checkHit();
    }

    private void checkHit() {
        for (int i = 0; i < generatorLevelOne.wallsArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(mainPlayer, generatorLevelOne.wallsArrayList.get(i))) {
                mainPlayer.hitWall();
            }
        }
    }

    public void drawing(CoreFw coreFw, GraphicsFw graphicsFw) {
        mainPlayer.drawing(graphicsFw);
        wall.drawing(graphicsFw);
        hud.drawing(graphicsFw);
        generatorLevelOne.drawing(graphicsFw);
    }
}
