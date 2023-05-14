package com.example.framework;

import android.graphics.Bitmap;

public class AnimationFw {

    double speedAnimation;
    int delayIndex; //Задержка индексов
    int countFrames;
    int frames;

    Bitmap sprite;
    Bitmap sprite1;
    Bitmap sprite2;

    public AnimationFw(double speedAnimation, Bitmap sprite1, Bitmap sprite2) {
        sprite = sprite1;
        this.speedAnimation = speedAnimation;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        frames = 20;
    }

    //Данный метод нужен для запуска анимации
    public void runAnimation() {
        delayIndex++;
        if (delayIndex > speedAnimation) {
            delayIndex = 0;
            nextFrame();
        }
    }

    private void nextFrame() {
        switch (countFrames) {
            case (0):
                sprite = sprite1;
                break;
            case (10):
                sprite = sprite2;
                break;
            default:
                break;
        }
        countFrames++;
        if (countFrames > frames) {
            countFrames = 0;
        }
    }

    public void drawingAnimation(GraphicsFw graphicsFw, int x, int y) {
        graphicsFw.drawTexture(sprite,x ,y);
    }
}
