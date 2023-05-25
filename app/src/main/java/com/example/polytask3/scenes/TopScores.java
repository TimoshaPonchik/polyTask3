package com.example.polytask3.scenes;

import android.graphics.Color;

import com.example.framework.CoreFw;
import com.example.framework.SceneFw;
import com.example.polytask3.R;
import com.example.polytask3.utilits.SettingsGame;

public class TopScores extends SceneFw {

    String[] numbers = new String[5];

    public TopScores(CoreFw coreFw) {
        super(coreFw);
        for (int i = 0; i < 5; i++) {
            this.numbers[i] = " " + (i + 1) + "." + SettingsGame.scores[i];
        }
    }

    @Override
    public void update() {
        if (coreFw.getTouchListenerFw().getTouchUp(0,sceneHeight,sceneWidth,sceneHeight)) {
            coreFw.setScene(new MainMenuScene(coreFw));
        }
    }

    @Override
    public void drawing() {
        graphicsFw.drawText(coreFw.getString(R.string.txt_top_scores), 120, 200, Color.WHITE, 40, null);
        graphicsFw.drawText(String.valueOf(numbers[0]), 120, 250, Color.WHITE, 35, null);
        graphicsFw.drawText(String.valueOf(numbers[1]), 120, 300, Color.WHITE, 35, null);
        graphicsFw.drawText(String.valueOf(numbers[2]), 120, 350, Color.WHITE, 35, null);
        graphicsFw.drawText(String.valueOf(numbers[3]), 120, 400, Color.WHITE, 35, null);
        graphicsFw.drawText(String.valueOf(numbers[4]), 120, 450, Color.WHITE, 35, null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        graphicsFw.clearScene(Color.BLACK);
    }

    @Override
    public void dispose() {

    }
}
