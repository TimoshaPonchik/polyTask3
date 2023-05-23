package com.example.polytask3.objects;

import android.graphics.Color;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.R;

public class HUD {
    private int timePassed;
    private int currentHealth;

    CoreFw coreFw;

    private final int HEIGHT_HUD = 64;

    public HUD(CoreFw coreFw) {
        this.coreFw = coreFw;
    }

    public void update(int coinsCollected, int currentHealth) {
        this.timePassed = coinsCollected;
        this.currentHealth = currentHealth;
    }

    public void drawing(GraphicsFw graphicsFw) {
        graphicsFw.drawLine(0, HEIGHT_HUD, graphicsFw.getWitdhFrameBuffer(), HEIGHT_HUD, Color.WHITE);
        graphicsFw.drawText(coreFw.getString(R.string.txt_HUD_coinsCollected) + ": " + timePassed, (int) (graphicsFw.getWitdhFrameBuffer() * 0.1), (int) (HEIGHT_HUD / 1.3), Color.WHITE, 45, null);
        graphicsFw.drawText(coreFw.getString(R.string.txt_HUD_currentHealth) + ": " + currentHealth, (int) (graphicsFw.getWitdhFrameBuffer() * 0.62), (int) (HEIGHT_HUD / 1.3), Color.WHITE, 45, null);
    }

    public int getTimePassed() {
        return timePassed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getHEIGHT_HUD() {
        return HEIGHT_HUD;
    }
}
