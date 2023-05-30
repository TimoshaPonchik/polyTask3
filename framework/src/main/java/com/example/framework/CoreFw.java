package com.example.framework;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import java.io.IOException;

public class CoreFw extends AppCompatActivity {

    private LoopFw loopFw;
    private GraphicsFw graphicsFw;
    private TouchListenerFw touchListenerFw;
    private SceneFw sceneFw;
    private boolean stateOnPause;
    private boolean stateOnResume;

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String SETTINGS = "settings";
        sharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        Point sizeDisplay = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);
        float FRAME_BUFFER_WIDTH = 600;
        float FRAME_BUFFER_HEIGHT = 800;
        Bitmap frameBuffer = Bitmap.createBitmap((int) FRAME_BUFFER_WIDTH, (int) FRAME_BUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        float sceneWidth = FRAME_BUFFER_WIDTH / sizeDisplay.x;
        float sceneHeight = FRAME_BUFFER_HEIGHT / sizeDisplay.y;

        loopFw = new LoopFw(this, frameBuffer);
        graphicsFw = new GraphicsFw(getAssets(), frameBuffer);
        touchListenerFw = new TouchListenerFw(loopFw, sceneWidth, sceneHeight);

        sceneFw = getStartScene();
        stateOnPause = false;
        stateOnResume = false;

        setContentView(loopFw);

    }

//    public CoreFw() {
//
//    }

    public void onResume() {
        super.onResume();
        sceneFw.resume();
        loopFw.startGame();
    }

    public void onPause() {
        super.onPause();
        sceneFw.pause();
        loopFw.stopGame();
        stateOnPause = true;
        if (isFinishing()) {
            sceneFw.dispose();
        }
    }

    public GraphicsFw getGraphicsFw() {
        return graphicsFw;
    }
    public TouchListenerFw getTouchListenerFw() {
        return touchListenerFw;
    }

    public void setScene(SceneFw sceneFw) {
        if (sceneFw == null) {
            throw new IllegalArgumentException("Невозможно загрузить сцену");
        }
        this.sceneFw.pause();
        this.sceneFw.dispose();
        sceneFw.resume();
        sceneFw.update();
        this.sceneFw = sceneFw;
    }

    public SceneFw getCurrentScene() {
        return sceneFw;
    }

    public SceneFw getStartScene() {
        return sceneFw;
    }
}
