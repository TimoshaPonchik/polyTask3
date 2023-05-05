package com.example.polytask3.classes;

import android.graphics.Bitmap;

import com.example.framework.GraphicsFw;

public class AnimationGame {

    double speedAnimation;
    int delayIndex; //Задержка индексов
    int countFrames;
    int frames;

    Bitmap sprite;
    Bitmap sprite1;
    Bitmap sprite2;
    Bitmap sprite3;
    Bitmap sprite4;

    public AnimationGame(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4) {
        sprite = sprite1;
        this.speedAnimation = speedAnimation;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        this.sprite4 = sprite4;
        frames = 4;
    }

    //Данный метод нужен для запуска анимации
    public void runAnimation() {
        delayIndex++;
        switch (countFrames) {
            case (0):
                sprite = sprite1;
                break;
            case (1):
                sprite = sprite2;
                break;
            case(2):
                sprite = sprite3;
                break;
            case(3):
                sprite = sprite4;
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
