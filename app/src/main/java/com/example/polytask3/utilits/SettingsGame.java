package com.example.polytask3.utilits;

import android.content.SharedPreferences;

import com.example.framework.CoreFw;

public class SettingsGame {
    public static int[] scores = {5555, 4444, 3333, 2222, 1111};

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

    public static void addDistance(int values) {
        for (int i = 0; i < 5; i++) {
            if (scores[i] < values) {
                for (int j = 4; j < 5; j--) {
                    scores[i] = scores[j - 1];
                }
                scores[i] = values;
                break;
            }
        }
    }
}
