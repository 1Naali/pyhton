package com.map;

import java.awt.image.BufferedImage;
import com.main.GameMain;

public class Log1 extends Tile {

    private Tile[] allTiles;
    private int width;
    private int height;
    private int originalX, originalY;

    // Sprites que você deve preencher com as coordenadas corretas da sua spritesheet
    private static BufferedImage LOG1_ALONE;
    private static BufferedImage LOG1_WITH_UP;
    private static BufferedImage LOG1_WITH_LEFT;
    private static BufferedImage LOG1_WITH_RIGHT;
    private static BufferedImage LOG1_WITH_UP_LEFT;
    private static BufferedImage LOG1_WITH_UP_RIGHT;
    private static BufferedImage LOG1_WITH_LEFT_RIGHT;
    private static BufferedImage LOG1_WITH_UP_LEFT_RIGHT;

    static {
        // Ajuste as coordenadas (x, y) de acordo com a sua spritesheet
        LOG1_ALONE = GameMain.sg.getSprite(0, 0, 32, 32); 
        LOG1_WITH_UP = GameMain.sg.getSprite(96, 160, 32, 32);
        LOG1_WITH_LEFT = GameMain.sg.getSprite(64, 160, 32, 32);
        LOG1_WITH_RIGHT = GameMain.sg.getSprite(0, 160, 32, 32);
        LOG1_WITH_UP_LEFT = GameMain.sg.getSprite(0, 0, 32, 32);
        LOG1_WITH_UP_RIGHT = GameMain.sg.getSprite(0, 0, 32, 32);
        LOG1_WITH_LEFT_RIGHT = GameMain.sg.getSprite(32, 160, 32, 32);
        LOG1_WITH_UP_LEFT_RIGHT = GameMain.sg.getSprite(0, 0, 32, 32);
    }

    public Log1(int x, int y, BufferedImage sprite, Tile[] allTiles, int mapWidth, int mapHeight) {
        super(x, y, sprite);
        this.originalX = x / 32;
        this.originalY = y / 32;
        this.allTiles = allTiles;
        this.width = mapWidth;
        this.height = mapHeight;
    }

    public void initializeSprite() {
        // Obtém o índice dos vizinhos
        int upIndex = (originalY - 1) * width + originalX;
        int leftIndex = originalY * width + (originalX - 1);
        int rightIndex = originalY * width + (originalX + 1);

        // Verifica se há vizinhos do tipo Log1 ou WoodTile2
        boolean hasUpNeighbor = originalY > 0 && 
                                (allTiles[upIndex] instanceof Log1 || allTiles[upIndex] instanceof WoodTile2);
        boolean hasLeftNeighbor = originalX > 0 && 
                                  (allTiles[leftIndex] instanceof Log1 || allTiles[leftIndex] instanceof WoodTile2);
        boolean hasRightNeighbor = originalX < width - 1 && 
                                   (allTiles[rightIndex] instanceof Log1 || allTiles[rightIndex] instanceof WoodTile2);

        // Atribui a sprite com base nas combinações
        if (hasUpNeighbor && hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = LOG1_WITH_UP_LEFT_RIGHT;
        } else if (hasUpNeighbor && hasLeftNeighbor) {
            this.sprite = LOG1_WITH_UP_LEFT;
        } else if (hasUpNeighbor && hasRightNeighbor) {
            this.sprite = LOG1_WITH_UP_RIGHT;
        } else if (hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = LOG1_WITH_LEFT_RIGHT;
        } else if (hasUpNeighbor) {
            this.sprite = LOG1_WITH_UP;
        } else if (hasLeftNeighbor) {
            this.sprite = LOG1_WITH_LEFT;
        } else if (hasRightNeighbor) {
            this.sprite = LOG1_WITH_RIGHT;
        } else {
            this.sprite = LOG1_ALONE;
        }
    }
}