package com.example.framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsFw {
    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Bitmap textureGame;
    private Canvas canvasGame;
    private Paint paintGame;

    public GraphicsFw(AssetManager assetManagerGame, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    public void clearScene(int colorRGB) {
        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    public void drawPixel(int x, int y, int color) {
        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }

    public void drawLine(int startX, int startY, int endX, int endY, int color) {
        paintGame.setColor(color);
        canvasGame.drawLine(startX, startY, endX, endY, paintGame);
    }

    public void drawText(String text, int x, int y, int color, int sizeText, Typeface font) {
        paintGame.setColor(color);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }

    public void drawTexture(Bitmap textureGame, int x, int y) {
        canvasGame.drawBitmap(textureGame, x, y, null);
    }

    public int getWitdhFrameBuffer() {
        return frameBufferGame.getWidth();
    }

    public int getHeightFrameBuffer() {
        return frameBufferGame.getHeight();
    }

    public Bitmap newTexture(String fileName) throws IOException {
        InputStream inputStream = null;
        inputStream = assetManagerGame.open(fileName);
        textureGame = BitmapFactory.decodeStream(inputStream);
        if (textureGame == null) {
            throw new RuntimeException("Невозможно загрузить файл: " + fileName);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return textureGame;
    }

    //данный метод возвращает спрайт
    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite) {
        Bitmap newSprite = Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
        return newSprite;
    }

}
