package com.example.polytask3.mapLevelGenerator;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.objects.Enemy;

import java.util.ArrayList;

public class GeneratorEnemyLevelOne extends ObjectFw {
    CoreFw coreFw;
    private int maxSreenY;
    private int maxSreenX;
    private int minSreenX;
    private int minSreenY;
    private int STACK_ENEMY = 3;
    private int xShift;
    private int yShift;
    private int currentX;
    private int currentY;

    public ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemyLevelOne(int sceneWidth, int sceneHeight, int minSreenY) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        this.minSreenY = minSreenY;
        this.minSreenX = 0;
        enemyArrayList = new ArrayList<Enemy>();
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void update(boolean checker) {
        if (checker) {
            enemyArrayList.clear();
        }
        if (enemyArrayList.size() < STACK_ENEMY) {
            addEnemyLvlOne();
        }

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update();
        }
    }


    public void addEnemyLvlOne() {

        if (currentX == 0 && currentY == 0) {
            int[][] levelOneEnemyArrCoord = new int[][]{
                    {8, 6, 1},
                    {3, 7, 2},
                    {7, 8, 2}
            };
            enemyGenerator(levelOneEnemyArrCoord);
        }

        if (currentX == 0 && currentY == -1) {
            int[][] levelOneEnemyArrCoord = new int[][]{
                    {3, 3, 2}};
            enemyGenerator(levelOneEnemyArrCoord);
        }
    }

    public void enemyGenerator(int[][] arrCoord) {
        for (int[] row : arrCoord) {
            enemyArrayList.add(new Enemy(maxSreenX, maxSreenY, row[1] * 64, row[0] * 64, row[2], coreFw));
        }
    }

    public void drawing(GraphicsFw graphicsFw) {

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFw);
        }
    }
}
