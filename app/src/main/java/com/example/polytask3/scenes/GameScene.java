package com.example.polytask3.scenes;

import android.graphics.Color;

import com.example.framework.CoreFw;
import com.example.framework.SceneFw;
import com.example.polytask3.R;
import com.example.polytask3.classes.GameManager;

public class GameScene extends SceneFw {

    //В игре будет несколько состояний (Ready,Running, Pause, Game Over)
    //этот класс отображает только игровую сцену
    enum GameState { //enum - перечисление, перечисления представляют набор логически связанных констант.
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;
    GameManager gameManager;

    public GameScene(CoreFw coreFw) {
        super(coreFw);
        //При запуске игровой сцены в первую очередь будет запускаться READY
        gameState = GameState.READY;
        gameManager = new GameManager(coreFw, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        //Каждую итерацию мы будем проверять, в каком состоянии у нас игра

        switch (gameState) {
            case READY:
                updateStateReady();
                break;
            case RUNNING:
                updateStateRunning();
                break;
            case PAUSE:
                updateStatePause();
                break;
            case GAMEOVER:
                updateStateGameOver();
                break;
            default:
                break;
        }
        //т.к. метод drawing тоже выполняется 60 раз в секунду, то мы и в нем делаем проверки
    }








    //
    @Override
    public void drawing() {
        graphicsFw.clearScene(Color.BLACK);

        if (gameState == gameState.READY) {
            drawingStateReady();
        }

        if (gameState == gameState.RUNNING) {
            drawingStateRunning();
        }

        if (gameState == gameState.PAUSE) {
            drawingStatePause();
        }

        if (gameState == gameState.GAMEOVER) {
            drawingStateGameOver();
        }
    }

    private void drawingStateGameOver() {
    }
    private void updateStateGameOver() {
    }

    private void drawingStatePause() {
    }
    private void updateStatePause() {
    }

    private void drawingStateRunning() {
        graphicsFw.clearScene((Color.BLACK));
        gameManager.drawing(coreFw, graphicsFw);
    }
    private void updateStateRunning() {
        gameManager.update();
    }

    private void drawingStateReady() {
        //изначально игра будет в состоянии READY, поэтому мы обращаемся к graphicsFw, которая работает с графикой и задаем графику
        graphicsFw.clearScene(Color.BLACK);
        graphicsFw.drawText(coreFw.getString(R.string.txt_gameScene_stateReady_ready), sceneWidth / 2 - 150, 300, Color.WHITE, 60, null);
    }
    private void updateStateReady() {
        if (coreFw.getTouchListenerFw().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = gameState.RUNNING;
        }
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
