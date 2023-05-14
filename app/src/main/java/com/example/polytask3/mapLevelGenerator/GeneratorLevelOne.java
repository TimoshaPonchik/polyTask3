package com.example.polytask3.mapLevelGenerator;

import com.example.framework.GraphicsFw;
import com.example.polytask3.objects.HUD;
import com.example.polytask3.objects.Wall;

import java.util.ArrayList;

public class GeneratorLevelOne {
    private int maxSreenY;
    private int maxSreenX;
    private int minSreenX;
    private int minSreenY;
    private int STACK_BLOCKS = 20;
    private int xShift;
    private int yShift;

    public ArrayList<Wall> wallsArrayList;

    public GeneratorLevelOne(int sceneWidth, int sceneHeight, int minSreenY) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        this.minSreenY = minSreenY;
        this.minSreenX = 0;
        wallsArrayList = new ArrayList<>();
    }

    public void update() {
        if (wallsArrayList.size() < STACK_BLOCKS) {
            addWallLvlOne(STACK_BLOCKS, minSreenY);
        }

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).update();
        }
    }

    private void addWallLvlOne(int amountOfWalls, int minSreenY) {
        yShift = minSreenY;
        xShift = 0;
        for (int j = 0; j < amountOfWalls; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            yShift += 64;
            yShift += 64;
            yShift += 64;
            yShift += 64;
            yShift += 64;
            if (yShift < STACK_BLOCKS * 64) System.out.println("STACK_BLOCKS");
    }

    public void drawing(GraphicsFw graphicsFw) {
        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).drawing(graphicsFw);
        }
    }
}
