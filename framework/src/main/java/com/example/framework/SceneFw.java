package com.example.framework;

public abstract class SceneFw {
    public CoreFw coreFw;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsFw graphicsFw;

    public SceneFw(CoreFw coreFw) {
        this.coreFw = coreFw;
        sceneWidth = coreFw.getGraphicsFw().getWitdhFrameBuffer();
        sceneHeight = coreFw.getGraphicsFw().getHeightFrameBuffer();
        graphicsFw = coreFw.getGraphicsFw();
    }

    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
