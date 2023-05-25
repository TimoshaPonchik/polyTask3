package com.example.polytask3.scenes;

import android.graphics.Color;

import com.example.framework.CoreFw;
import com.example.framework.SceneFw;
import com.example.polytask3.R;
import com.example.polytask3.classes.GameManager;
import com.example.polytask3.utilits.SettingsGame;

public class GameScene extends SceneFw {

    //В игре будет несколько состояний (Ready,Running, Pause, Game Over)
    //этот класс отображает только игровую сцену
    enum GameState { //enum - перечисление, перечисления представляют набор логически связанных констант.
        READY, RUNNING, PAUSE, GAMEOVER, WIN
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
            case WIN:
                updateStateWin();
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

        if (gameState == gameState.WIN) {
            drawingStateWin();
        }
    }
    private void updateStateWin() {
        if (coreFw.getTouchListenerFw().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            SettingsGame.addScores(gameManager.getTimePassed());
            coreFw.setScene(new MainMenuScene(coreFw));
        }
    }

    private void drawingStateWin() {
        graphicsFw.drawText(coreFw.getString(R.string.txt_gameScene_stateGameWin_gameWin), 100, 300, Color.WHITE, 60, null);
    }

    private void drawingStateGameOver() {
        graphicsFw.clearScene(Color.BLACK);
        graphicsFw.drawText(coreFw.getString(R.string.txt_gameScene_stateGameOver_gameOver), 100, 300, Color.WHITE, 60, null);
        graphicsFw.drawText(coreFw.getString(R.string.txt_gameScene_stateGameOver_restart), 100, 360, Color.WHITE, 60, null);
        graphicsFw.drawText(coreFw.getString(R.string.txt_gameScene_stateGameOver_exit), 100, 420, Color.WHITE, 60, null);
    }

    private void updateStateGameOver() {
        if (coreFw.getTouchListenerFw().getTouchUp(250, 360, 100, 35)) {
            coreFw.setScene(new GameScene(coreFw));

        }
        if (coreFw.getTouchListenerFw().getTouchUp(250, 420, 100, 35)) {
            coreFw.setScene(new MainMenuScene(coreFw));
        }
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
        if (GameManager.gameOver) {
            gameState = GameState.GAMEOVER;
        }

        if (GameManager.gameWin) {
            gameState = GameState.WIN;
        }
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
