package com.example.framework;


import android.graphics.Rect;

//Абстрактный класс, потому что мы не будем создавать экземпляры этого класса, каждый класс будет
// наследоваться от этого Абстратного класса, поэтому здесь мы должны определить что каждый класс
// должен уметь делать
public class ObjectFw {
    //Реализация того, что ничего не должно выходить за экран
    protected int maxScreenX;
    protected int maxScreenY;
    protected int minScreenX;
    protected int minScreenY;
    protected int x;
    protected int y;
    protected double speed;

    Rect hitBox;
    double radius; // для определения столкновений

    public int getMaxScreenX() {
        return maxScreenX;
    }

    public void setMaxScreenX(int maxScreenX) {
        this.maxScreenX = maxScreenX;
    }

    public int getMaxScreenY() {
        return maxScreenY;
    }

    public void setMaxScreenY(int maxScreenY) {
        this.maxScreenY = maxScreenY;
    }

    public int getMinScreenX() {
        return minScreenX;
    }

    public void setMinScreenX(int minScreenX) {
        this.minScreenX = minScreenX;
    }

    public int getMinScreenY() {
        return minScreenY;
    }

    public void setMinScreenY(int minScreenY) {
        this.minScreenY = minScreenY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Rect getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rect hitBox) {
        this.hitBox = hitBox;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
