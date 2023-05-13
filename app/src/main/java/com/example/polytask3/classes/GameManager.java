package com.example.polytask3.classes;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.objects.MainPlayer;
import com.example.polytask3.objects.Wall;

public class GameManager {
    //класс выполняет логику всей игры, руководит всей игрой (коллизии, удары итд...)
    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    MainPlayer mainPlayer;
    Wall wall;

    public GameManager(CoreFw coreFw, int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenY = 0;
        minScreenX = 0;
        mainPlayer = new MainPlayer(coreFw, maxScreenX, maxScreenY, minScreenY);
        wall = new Wall(maxScreenX, maxScreenY, minScreenY);
    }

    public void update() {
        mainPlayer.update();
        wall.update();
    }

    public void drawing(CoreFw coreFw, GraphicsFw graphicsFw) {
        mainPlayer.drawing(graphicsFw);
        wall.drawing(graphicsFw);
    }
}
