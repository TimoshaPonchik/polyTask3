package com.example.polytask3.scenes;

import android.graphics.Color;

import com.example.framework.CoreFw;
import com.example.framework.SceneFw;
import com.example.polytask3.R;

public class MainMenuScene extends SceneFw {

    public MainMenuScene(CoreFw coreFw) {
        super(coreFw);
    }

    // метод update запускается и обновляется 60 раз в секунду
    @Override
    public void update() {
        //проверяем на каждом кадре, был ли произведен клик
        if (coreFw.getTouchListenerFw().getTouchUp(190, 380, 180, 40)) {
            //Передавая данные мы отслеживаем, нажал пользователь или не нажал, если нажал - то ->
            coreFw.setScene(new GameScene(coreFw));
            //фреймворк уже обрабатывает
        }

    }

    @Override
    public void drawing() {
        graphicsFw.clearScene(Color.BLACK); // при запуске мы будем полностью окрашивать наш экран в черный цвет
        graphicsFw.drawText(coreFw.getString(R.string.txt_mainMenu_nameGame), sceneWidth / 2 - 180, (int) (sceneHeight * 0.2), Color.WHITE, 60, null);
        //рисуем графику методом drawText(), тк каждая сцена работает с ядром, то мы обращаемся к ядру
        //мы рисуем эти буквы на franebuffer фиксированной ширины и высоты
        graphicsFw.drawText(coreFw.getString(R.string.txt_mainMenu_newGame), sceneWidth / 2 - 100, (int) (sceneHeight * 0.5), Color.WHITE, 40, null);
        graphicsFw.drawText(coreFw.getString(R.string.txt_mainMenu_settings), sceneWidth / 2 - 80, (int) (sceneHeight * 0.6), Color.WHITE, 40, null);
        graphicsFw.drawText(coreFw.getString(R.string.txt_mainMenu_exitGame), sceneWidth / 2 - 60, (int) (sceneHeight * 0.7), Color.WHITE, 40, null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
