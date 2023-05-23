package com.example.framework.utilits;

public class UtilTimerDelay {
    double startTime;
    double nowTime;
    double elapsedTime;
    final double SECONDS = 1_000_000_000; //тк java работает с наносекундами

    public void startTimer() {
        startTime = System.nanoTime() / SECONDS;
    }

    public boolean timerDelay(double seconds) {
        nowTime = System.nanoTime() / SECONDS;
        elapsedTime = nowTime - startTime;
        return elapsedTime > seconds;
    }
}
