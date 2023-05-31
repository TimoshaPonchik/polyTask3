package com.example.polytask3.mapLevelGenerator;

import com.example.framework.GraphicsFw;
import com.example.framework.ObjectFw;
import com.example.polytask3.objects.Wall;

import java.util.ArrayList;

public class GeneratorWallLevelOne extends ObjectFw {
    private final int maxSreenY;
    private final int maxSreenX;
    private int xShift;
    private int yShift;
    private int currentX;
    private int currentY;
    public static String seedGame;
    public static int seedRoom;

    public ArrayList<Wall> wallsArrayList;

    public GeneratorWallLevelOne(int sceneWidth, int sceneHeight) {
        this.maxSreenX = sceneWidth;
        this.maxSreenY = sceneHeight;
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
        int STACK_BLOCKS = 20;
        if (wallsArrayList.size() < STACK_BLOCKS) {
            addWallLvlOne();
        }

        for (int i = 0; i < wallsArrayList.size(); i++) {
            wallsArrayList.get(i).update();
        }
    }


    private void addWallLvlOne() {
        if (currentX == 0 && currentY == 0) {
            int[][] levelOneArrCoord = new int[][]{{0, 6}, {9, 6}, {4, 1}};
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(0));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }

        if (currentX == 0 && currentY == -1) {
            int[][] levelOneArrCoord = new int[2][2];
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(1));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            switch (seedRoom) {
                case (1):
                case (5):
                    levelOneArrCoord[0][0] = 0;
                    levelOneArrCoord[0][1] = 6;
                    levelOneArrCoord[1][0] = 9;
                    levelOneArrCoord[1][1] = 6;
                    break;
                default:
                    levelOneArrCoord[0][0] = 0;
                    levelOneArrCoord[0][1] = 6;
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 12;
                    break;

            }
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }

        if (currentX == 0 && currentY == -2) {
            int[][] levelOneArrCoord = new int[][]{{0, 6}, {4, 12}};
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(2));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 1 && currentY == 0) {
            int[][] levelOneArrCoord = new int[][]{{0, 6}, {4, 1}};
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(3));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 1 && currentY == -1) {
            int[][] levelOneArrCoord = new int[2][2];
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(4));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            switch (seedRoom) {
                case (1):
                    levelOneArrCoord[0][0] = 0;
                    levelOneArrCoord[0][1] = 6;
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 1;
                    break;
                case (2):
                    levelOneArrCoord[0][0] = 4;
                    levelOneArrCoord[0][1] = 1;
                    levelOneArrCoord[1][0] = 9;
                    levelOneArrCoord[1][1] = 6;
                    break;
                case (3):
                    levelOneArrCoord[0][0] = 4;
                    levelOneArrCoord[0][1] = 1;
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 12;
                    break;
                case (4):
                    levelOneArrCoord[0][0] = 4;
                    levelOneArrCoord[0][1] = 12;
                    levelOneArrCoord[1][0] = 9;
                    levelOneArrCoord[1][1] = 6;
                    break;
            }
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 1 && currentY == -2) {
            int[][] levelOneArrCoord = new int[2][2];
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(5));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            levelOneArrCoord[0][0] = 4;
            levelOneArrCoord[0][1] = 12;
            switch (seedRoom) {
                case (1):
                    levelOneArrCoord[1][0] = 9;
                    levelOneArrCoord[1][1] = 6;
                    break;
                case (2):
                    levelOneArrCoord[1][0] = 0;
                    levelOneArrCoord[1][1] = 6;
                    break;
                case (5):
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 1;
                    break;
            }
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 2 && currentY == 0) {
            int[][] levelOneArrCoord = new int[][]{{4, 1}, {9, 6}};
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(6));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 2 && currentY == -1) {
            int[][] levelOneArrCoord = new int[2][2];
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(7));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            levelOneArrCoord[0][0] = 9;
            levelOneArrCoord[0][1] = 6;
            switch (seedRoom) {
                case (1):
                case (3):
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 1;
                    break;
                case (4):
                    levelOneArrCoord[1][0] = 0;
                    levelOneArrCoord[1][1] = 6;
                    break;
            }
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }
        if (currentX == 2 && currentY == -2) {
            int[][] levelOneArrCoord = new int[2][2];
            GeneratorRooms generatorRooms = new GeneratorRooms(seedGame.charAt(8));
            int[][] levelTwoArrCoord = generatorRooms.generatorRoomsGetter();
            levelOneArrCoord[0][0] = 9;
            levelOneArrCoord[0][1] = 6;
            switch (seedRoom) {
                case (1):
                case (3):
                case (4):
                    levelOneArrCoord[1][0] = 0;
                    levelOneArrCoord[1][1] = 6;
                    break;
                case (2):
                case (5):
                    levelOneArrCoord[1][0] = 4;
                    levelOneArrCoord[1][1] = 1;
                    break;
            }
            blockGenerator(levelOneArrCoord);
            blockGenerator(levelTwoArrCoord);
        }


    }

    private void blockGenerator(int[][] arrCoord) {
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
