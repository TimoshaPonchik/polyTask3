package com.example.polytask3.classes;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.objects.MainPlayer;

public class GameManager {
    //класс выполняет логику всей игры, руководит всей игрой (коллизии, удары итд...)
    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    MainPlayer mainPlayer;

    public GameManager(CoreFw coreFw, int sceneWidth, int sceneHeight) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenY = 0;
        minScreenX = 0;
        mainPlayer = new MainPlayer(maxScreenX, maxScreenY, minScreenY);
    }

    public void update() {
        mainPlayer.update();
    }

    public void drawing(CoreFw coreFw, GraphicsFw graphicsFw) {
        mainPlayer.drawing(graphicsFw);
    }
}
