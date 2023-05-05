package com.example.framework;


import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

//класс, предназначенный для считывания "кликов" с экрана
public class TouchListenerFw implements View.OnTouchListener {
    //класс имплементирует View.OnTouchListener

    //считываем место нажатия
    float touchX;
    float touchY;

    boolean isTouchDown;
    boolean isTouchUp;

    //ширина и высота сцены
    float sceneWidth;
    float sceneHeight;


    //конструктор, который принимает view, sceneWidth, sceneHeight
    public TouchListenerFw(@NonNull View view, float sceneWidth, float sceneHeight) {
        //подключаем слушатель событий и передаем туда "this"
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    //добавляем методы View.OnTouchListener, который принимает компонент View и MotionEvent
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        //Обрабатываем событием (понимаем, нажал пользователь кнопку или отжал и в каком месте он это сделал)

        /*
        синхронизируем Synchronized (с англ. "синхронизированный") - это ключевое слово, которое
        позволяет заблокировать доступ к методу или части кода, если его уже использует другой поток.
         */
        synchronized (this) {
            isTouchDown = false;
            isTouchUp = false;
            // switch - условный оператор, который дает возможность сравнивать переменную со списком значений
            //ход работы: мы получили какое-то событие, оператором switch мы проверяем
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchX = event.getX() * sceneWidth;
                    touchY = event.getY() * sceneHeight;
                    isTouchDown = true;
                    isTouchUp = false;
                    break;
                case MotionEvent.ACTION_UP:
                    touchX = event.getX() * sceneWidth;
                    touchY = event.getY() * sceneHeight;
                    isTouchDown = false;
                    isTouchUp = true;
                    break;
            }

        }
        return true;
    }

    //метод принимает x, y, высоты и ширину нашей области
    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchUp) {
            // проверка на то, нажал ли пользователь на нужную область или нет (нужная область - та область, которую мы передаем как параметр в этот метод)
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - touchHeight -1) {
                isTouchUp = false;
                return true;
            }
        }
        return false;
    }


    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchDown) {
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - touchHeight -1) {
                isTouchDown = false;
                return true;
            }
        }
        return false;
    }
}
