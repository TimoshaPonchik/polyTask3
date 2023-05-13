package com.example.polytask3.classes;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.polytask3.utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {
    //как только loader запускается - он будет запускать 2 основных метода
    public LoaderAssets(CoreFw coreFw, GraphicsFw graphicsFw) {
        loadTexture(graphicsFw);
        loadSpritePlayer(graphicsFw);
        loadSpriteBlock(graphicsFw);
    }

    private void loadSpriteBlock(GraphicsFw graphicsFw) {
        UtilResource.spriteWall = new ArrayList<>();
        UtilResource.spriteWall.add(graphicsFw.newSprite(UtilResource.textureAtlas, 384, 384, 64, 64));
    }

    //В arrayList по очереди добавили все картинки из Atlas
    private void loadSpritePlayer(GraphicsFw graphicsFw) {
        //инициализируем arraylist
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayerBoost = new ArrayList<>();

        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 192, 64, 64, 64));
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 256, 64, 64, 64));

        UtilResource.spritePlayerBoost.add(graphicsFw.newSprite(UtilResource.textureAtlas, 448, 64, 64, 64));
    }

    //Загружаем Atlas
    private void loadTexture(GraphicsFw graphicsFw) {
        UtilResource.textureAtlas = graphicsFw.newTexture("texture_environment.png");
    }


}
