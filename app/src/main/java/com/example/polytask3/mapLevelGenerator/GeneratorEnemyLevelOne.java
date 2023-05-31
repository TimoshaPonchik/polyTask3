package com.example.polytask3.mapLevelGenerator;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.objects.Enemy;

import java.util.ArrayList;

public class GeneratorEnemyLevelOne extends ObjectFw {
    CoreFw coreFw;
    private final int maxSreenY;
    private final int maxSreenX;
    private int xShift;
    private int yShift;
    private int currentX;
    private int currentY;
    public static String seedGame;


    public ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemyLevelOne(int sceneWidth, int sceneHeight) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
        enemyArrayList = new ArrayList<>();
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
        int STACK_ENEMY = 4;
        if (enemyArrayList.size() < STACK_ENEMY) {
            addEnemyLvlOne();
        }

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update();
        }
    }


    private void addEnemyLvlOne() {
        if (currentX == 0 && currentY == 0) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(0));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 0 && currentY == -1) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(1));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 0 && currentY == -2) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(2));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 1 && currentY == 0) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(3));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 1 && currentY == -1) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(4));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 1 && currentY == -2) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(5));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 2 && currentY == 0) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(6));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }

        if (currentX == 2 && currentY == -1) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(7));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }
        if (currentX == 2 && currentY == -2) {
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(8));
            int[][] levelTwoArrCoord = generatorRooms.generatorEnemiesGetter();
            enemyGenerator(levelTwoArrCoord);
        }
    }

    private void enemyGenerator(int[][] arrCoord) {
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
