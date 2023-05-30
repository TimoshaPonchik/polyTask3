package com.example.framework.utilits;


//Данный метод рандомайзит

import java.util.Random;

public class UtilRandomFw {
    public static int getCasualNumber(int number) {
        //определяем переменную типа рандом "random"
        Random random = new Random();
        int casualNumber;
        casualNumber = random.nextInt(number);
        return  casualNumber;
    }

    public static int getGap(int minNumber, int maxNumber) {
        int gap;
        gap = (int) ((Math.random() * ++maxNumber) + minNumber);
        return gap;
    }
}
