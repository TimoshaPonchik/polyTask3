package com.example.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopFw extends SurfaceView implements Runnable { //surfaceView - loop расширяет класс SurfaceView, данный класс позволяет работать с динамичной графиокй

    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND / FPS;

    private boolean running = false;

    Thread gameThread = null;
    //создаем экземпляры
    CoreFw coreFw;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopFw(CoreFw coreFw, Bitmap frameBuffer) {
        super(coreFw);
        this.frameBuffer = frameBuffer;
        this.coreFw = coreFw;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    //temp
    float updates = 0;
    float drawing = 0;
    long timer = 0;
    //temp

    @Override
    public void run() {
        timer = System.currentTimeMillis();

        float lastTime = System.nanoTime();
        float delta = 0;
        while (running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime / UPDATE_TIME;
            if (delta>1) {
                updateGame();
                drawingGame();
                delta--;
            }
        }

    }

    private void updateGame() {
        updates++;
        coreFw.getCurrentScene().update();
    }

    private void drawingGame() {
        drawing++;
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            coreFw.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void startGame() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this); //метод run становится новым потоком, потому что this указывает на него
        //(указываем через this потому что в имплементируемом интерфейсе есть только один единственный метод run)
        gameThread.start();
    }

    public void stopGame() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
