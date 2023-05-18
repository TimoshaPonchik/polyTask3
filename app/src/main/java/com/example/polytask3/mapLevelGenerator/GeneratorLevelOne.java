package com.example.polytask3.mapLevelGenerator;

import android.widget.Switch;

import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.objects.MainPlayer;
import com.example.polytask3.objects.Wall;

import java.util.ArrayList;

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

    public GeneratorLevelOne(int sceneWidth, int sceneHeight, int minSreenY, int currentMovementX, int currentMovementY) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        this.minSreenY = minSreenY;
        this.minSreenX = 0;
        wallsArrayList = new ArrayList<>();
        checkDir(currentMovementX, currentMovementY);
    }

    private void checkDir(int currentMovementX, int currentMovementY) {
        currentX = currentMovementX;
        currentY = currentMovementY;
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

        if (currentX == 0 && currentY == 0) {
            yShift = minSreenY;
            xShift = 0;
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
            System.out.println("AAAAAAAAAAAAAAAAAA");
            xShift = 0;
            for (int j = 0; j < amountOfWalls; j++) {
                    wallsArrayList.add(new Wall(maxSreenX, maxSreenY, yShift, xShift));
            }
        }
    }

    public void drawing(GraphicsFw graphicsFw) {

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).drawing(graphicsFw);
        }
    }
}
