package com.example.polytask3.utilits;

import android.content.SharedPreferences;

import com.example.framework.CoreFw;

public class SettingsGame {
    public static int[] scores = {0, 0, 0, 0, 0};
    public static final int scoreLines = 5;

    public static void saveSettings(CoreFw coreFw) {
        SharedPreferences.Editor editor = coreFw.getSharedPreferences().edit();
        editor.clear();
        for (int i = 0; i < 5; i++) {
            editor.putInt("earnedScores" + i, scores[i]);
        }
        editor.apply();
    }

    public static void loadSettings(CoreFw coreFw) {
        for (int i = 0; i < 5; i++) {
            scores[i] = coreFw.getSharedPreferences().getInt("earnedScores" + i, scores[i]);
        }
    }

    public static void addScores(int values) {
        int i = 0;
        boolean checker = true;
        while (i < scoreLines - 1) {
            if (scores[i] < values && checker) {
                for (int j = scoreLines - 1; j > i; j--) {
                    scores[j] = scores[j - 1];
                }
                scores[i] = values;
                checker = false;
            } else if (scores[i] == values && checker) {
                scores[i] = values;
                checker = false;
            }
            i += 1;
        }

    }
}
