package com.example.framework.utilits;
import java.util.Formatter;

public class UtilTime {
    double startTime;
    double nowTime;
    double elapsedTime;
    final double SECONDS = 1_000_000_000;

    public void startTime() {
        Formatter formatter = new Formatter();
        startTime = System.nanoTime() / SECONDS;
    }

    public int timeDelay() {
        nowTime = System.nanoTime() / SECONDS;
        elapsedTime = nowTime - startTime;
        return (int) elapsedTime;
    }
}
