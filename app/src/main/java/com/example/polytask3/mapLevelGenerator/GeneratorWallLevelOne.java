package com.example.polytask3.mapLevelGenerator;

import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.objects.Wall;

import java.util.ArrayList;

public class GeneratorWallLevelOne extends ObjectFw {
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

    public GeneratorWallLevelOne(int sceneWidth, int sceneHeight, int minSreenY) {
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
            addWallLvlOne();
        }

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).update();
        }
    }


    public void addWallLvlOne() {

        if (currentX == 0 && currentY == 0) {
            int[][] levelOneArrCoord = new int[][]{
                    {0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1},
                    {0, 2}, {9, 2},
                    {0, 3}, {5, 3}, {6, 3}, {7, 3}, {9, 3},
                    {0, 4}, {1, 4}, {2, 4}, {3, 4}, {4, 4}, {5, 4}, {9, 4},
                    {0, 5}, {7, 5}, {8, 5}, {9, 5},
                    {0, 6}, {2, 6}, {4, 6}, {9, 6},
                    {0, 7}, {2, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}, {9, 7},
                    {0, 8}, {2, 8}, {9, 8},
                    {0, 9}, {2, 9}, {5, 9}, {9, 9},
                    {0, 10}, {2, 10}, {3, 10}, {9, 10},
                    {0, 11}, {9, 11},
                    {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12},
            };
            blockGenerator(levelOneArrCoord);
        }

        if (currentX == 0 && currentY == -1) {
            int[][] levelOneWallsArrCoord = new int[][]{
                    {0,1}, {1,1}, {2,1}, {3,1}, {5,1}, {6,1}, {7,1}, {8,1}, {9,1},
                    {0,2}, {8,2}, {9,2},
                    {0,3}, {5,3}, {9,3},
                    {0,4}, {2,4}, {5,4},
                    {0,5}, {2,5}, {6,5}, {9,5},
                    {0,6}, {7,6}, {9,6},
                    {0,7}, {2,7}, {3,7}, {7,7}, {9,7},
                    {0,8}, {7,8}, {9,8},
                    {0,9}, {2,9}, {3,9}, {7,9}, {9,9},
                    {0,10}, {2,10}, {7,10}, {9,10},
                    {0,11}, {2,11}, {9,11},
                    {0,12}, {1,12}, {2,12}, {3,12}, {4,12}, {5,12}, {6,12}, {7,12}, {8,12}, {9,12}};
            blockGenerator(levelOneWallsArrCoord);
        }
    }

    public void blockGenerator(int[][] arrCoord) {
        for (int[] row : arrCoord) {
            wallsArrayList.add(new Wall(maxSreenX, maxSreenY, row[1] * 64, row[0] * 64));
        }
    }

    public void drawing(GraphicsFw graphicsFw) {

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).drawing(graphicsFw);
        }
    }
}
