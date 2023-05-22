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
        loadSpriteEnemy(graphicsFw);
        loadHitPlayer(graphicsFw);
    }

    private void loadHitPlayer(GraphicsFw graphicsFw) {
        UtilResource.spriteHitPlayer = new ArrayList<>();
        UtilResource.spriteHitPlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 9 * 64, 6 * 64, 64, 64));
        UtilResource.spriteHitPlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 10 * 64, 6 * 64, 64, 64));
    }

    private void loadSpriteEnemy(GraphicsFw graphicsFw) {
        UtilResource.spriteEnemy = new ArrayList<>();
        UtilResource.spriteEnemy.add(graphicsFw.newSprite(UtilResource.textureAtlas, 8 * 64, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFw.newSprite(UtilResource.textureAtlas, 9 * 64, 64, 64, 64));
    }

    private void loadSpriteBlock(GraphicsFw graphicsFw) {
        UtilResource.spriteWall = new ArrayList<>();
        UtilResource.spriteWall.add(graphicsFw.newSprite(UtilResource.textureAtlas, 6 * 64, 6 * 64, 64, 64));
    }

    //В arrayList по очереди добавили все картинки из Atlas
    private void loadSpritePlayer(GraphicsFw graphicsFw) {
        //инициализируем arraylist
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayerBoost = new ArrayList<>();

        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 3 * 64, 64, 64, 64));
        UtilResource.spritePlayer.add(graphicsFw.newSprite(UtilResource.textureAtlas, 4 * 64, 64, 64, 64));

        UtilResource.spritePlayerBoost.add(graphicsFw.newSprite(UtilResource.textureAtlas, 448, 64, 64, 64));
    }

    //Загружаем Atlas
    private void loadTexture(GraphicsFw graphicsFw) {
        UtilResource.textureAtlas = graphicsFw.newTexture("texture_environment.png");
    }


}
