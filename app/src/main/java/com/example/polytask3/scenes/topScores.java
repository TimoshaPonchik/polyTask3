package com.example.polytask3.scenes;

import com.example.framework.CoreFw;
import com.example.framework.SceneFw;
import com.example.polytask3.utilits.SettingsGame;

public class topScores extends SceneFw {

    String[] numbers = new String[5];

    public topScores(CoreFw coreFw) {
        super(coreFw);
        for (int i = 0; i < 5; i++) {
            this.numbers[i] = " "+(i+1)+"." + SettingsGame.scores[i];
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {

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
