package com.example.polytask3.mapLevelGenerator;

public class GeneratorRooms {
    private char seedChar;

    int[][] levelOneEnemyArrCoordType1 = new int[][]{
            {5, 2, 2}, {7, 2, 2}, {8, 5, 1}, {3, 8, 2}
    };

    int[][] levelOneEnemyArrCoordType2 = new int[][]{
            {7, 2, 2}, {3, 11, 2}, {6, 11, 2}
    };

    int[][] levelOneEnemyArrCoordType3 = new int[][]{
            {1, 3, 1}, {5, 3, 1}, {7, 2, 2}, {1, 9, 1}
    };

    int[][] levelOneArrCoordType1 = new int[][]{
            {0, 1}, {1, 1}, {2, 1}, {3, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1},
            {0, 2}, {9, 2}, {3, 2},
            {0, 3}, {9, 3},
            {0, 4}, {9, 4},
            {0, 5}, {9, 5}, {1, 5}, {5, 5},
            {4, 6},
            {0, 7}, {9, 7}, {3, 7}, {8, 7},
            {0, 8}, {9, 8},
            {0, 9}, {9, 9},
            {0, 10}, {9, 10},
            {0, 11}, {9, 11}, {5, 11},
            {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12},
    };

    int[][] levelOneArrCoordType2 = new int[][]{
            {0, 1}, {1, 1}, {2, 1}, {3, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1},
            {0, 2}, {9, 2}, {1, 2}, {5, 2},
            {0, 3}, {9, 3}, {1, 3}, {3, 3}, {4, 3}, {5, 3},
            {0, 4}, {9, 4}, {6, 4},
            {0, 5}, {9, 5}, {3, 5},
            {7, 6},
            {0, 7}, {9, 7}, {3, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7},
            {0, 8}, {9, 8},
            {0, 9}, {9, 9},
            {0, 10}, {9, 10}, {1, 10},
            {0, 11}, {9, 11}, {5, 11}, {8, 11},
            {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12},
    };

    int[][] levelOneArrCoordType3 = new int[][]{
            {0, 1}, {1, 1}, {2, 1}, {3, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1},
            {0, 2}, {9, 2}, {5, 2},
            {0, 3}, {9, 3}, {4, 3},
            {0, 4}, {9, 4}, {4, 4},
            {0, 5}, {9, 5}, {1, 5}, {2, 5}, {4, 5}, {5, 5},
            {2, 6}, {4, 6},
            {0, 7}, {9, 7}, {2, 7}, {4, 7},
            {0, 8}, {9, 8}, {4, 8}, {8, 8},
            {0, 9}, {9, 9},
            {0, 10}, {9, 10}, {3, 10}, {4, 10}, {5, 10},
            {0, 11}, {9, 11}, {1, 11}, {5, 11},
            {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12},
    };

    public GeneratorRooms(char seedChar) {
        this.seedChar = seedChar;
    }

    public int[][] generatorRoomsGetter() {

        switch (seedChar) {
            case '1':
                return levelOneArrCoordType1;
            case '2':
                return levelOneArrCoordType2;
            default:
                return levelOneArrCoordType3;
        }
    }

    public int[][] generatorEnemiesGetter() {

        switch (seedChar) {
            case '1':
                return levelOneEnemyArrCoordType1;
            case '2':
                return levelOneEnemyArrCoordType2;
            default:
                return levelOneEnemyArrCoordType3;
        }
    }
}
