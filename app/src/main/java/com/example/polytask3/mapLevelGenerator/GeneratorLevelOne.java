package com.example.polytask3.mapLevelGenerator;

import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.classes.GameManager;
import com.example.polytask3.objects.Wall;

import java.util.ArrayList;
import java.util.Collections;

public class GeneratorLevelOne extends ObjectFw {
    private int maxSreenY;
    private int maxSreenX;
    private int minSreenX;
    private int minSreenY;
    private int STACK_BLOCKS = 20;
    private int xShift;
    private int yShift;
    private int currentX;
    private int currentY;

    public ArrayList<Wall> wallsArrayList;

    public GeneratorLevelOne(int sceneWidth, int sceneHeight, int minSreenY) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        this.minSreenY = minSreenY;
        this.minSreenX = 0;
        wallsArrayList = new ArrayList<>();
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void update(boolean checker) {
        if (checker) {
            wallsArrayList.clear();
        }
        if (wallsArrayList.size() < STACK_BLOCKS) {
            addWallLvlOne(STACK_BLOCKS, minSreenY);
        }

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).update();
        }
    }


    private void addWallLvlOne(int amountOfWalls, int minSreenY) {

        if (currentX == 0 && currentY == 0) {
            yShift = minSreenY;
            xShift = 0;
            for (int j = 0; j < amountOfWalls; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
            for (int j = 0; j < amountOfWalls; j++) {
                if (j < 1 || j > amountOfWalls - 13)
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            xShift = 0;
            yShift += 64;
        }

        if (currentX == 0 && currentY == -1) {
            yShift = minSreenY;
            for (int j = 0; j < 1; j++) {
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < 1; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < 1; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < 1; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < 1; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < 1; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
            yShift += 64;
            xShift = 0;
            for (int j = 0; j < amountOfWalls; j++) {
                wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
                xShift += 64;
            }
        }
    }

    public void drawing(GraphicsFw graphicsFw) {

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).drawing(graphicsFw);
        }
    }
}
