package com.example.polytask3.classes;

import com.example.framework.CoreFw;
import com.example.framework.GraphicsFw;
import com.example.framework.utilits.UtilResource;

import java.io.IOException;
import java.util.ArrayList;

public class LoaderAssets {
    //как только loader запускается - он будет запускать 2 основных метода
    public LoaderAssets(CoreFw coreFw, GraphicsFw graphicsFw) throws IOException {
        loadTexture(graphicsFw);
        loadSpritePlayer(graphicsFw);
    }

    //В arrayList по очереди добавили все картинки из Atlas
    private void loadSpritePlayer(GraphicsFw graphicsFw) {
        //инициализируем arraylist
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 0, 0, 10, 10));
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 10, 0, 10, 10));
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 20, 0, 10, 10));
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 30, 0, 10, 10));
    }

    //Загружаем Atlas
    private void loadTexture(GraphicsFw graphicsFw) throws IOException {
        UtilResource.textureAtlas = graphicsFw.newTexture("texture_environment");
    }


}
