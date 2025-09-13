package com.map;

import java.awt.image.BufferedImage;
import com.main.GameMain;

public class WoodTile2 extends Tile {

    private Tile[] allTiles;
    private int width;
    private int height;
    private int originalX, originalY;

    // Sprites que você deve preencher com as coordenadas corretas da sua spritesheet
    private static BufferedImage WOOD2_ALONE;
    private static BufferedImage WOOD2_WITH_LEFT;
    private static BufferedImage WOOD2_WITH_RIGHT;
    private static BufferedImage WOOD2_WITH_LEFT_RIGHT;

    static {
        // Ajuste as coordenadas (x, y) de acordo com a sua spritesheet
        WOOD2_ALONE = GameMain.sg.getSprite(0, 0, 32, 32); 
        WOOD2_WITH_LEFT = GameMain.sg.getSprite(64, 128, 32, 32);
        WOOD2_WITH_RIGHT = GameMain.sg.getSprite(0, 128, 32, 32);
        WOOD2_WITH_LEFT_RIGHT = GameMain.sg.getSprite(32, 128, 32, 32);
    }

    public WoodTile2(int x, int y, BufferedImage sprite, Tile[] allTiles, int mapWidth, int mapHeight) {
        super(x, y, sprite);
        this.originalX = x / 32;
        this.originalY = y / 32;
        this.allTiles = allTiles;
        this.width = mapWidth;
        this.height = mapHeight;
    }

    public void initializeSprite() {
        // Obtém o índice dos vizinhos de esquerda e direita
        int leftIndex = originalY * width + (originalX - 1);
        int rightIndex = originalY * width + (originalX + 1);

        // Verifica a existência de vizinhos que são do tipo WoodTile OU WoodTile2
        boolean hasLeftNeighbor = originalX > 0 && 
                                  (allTiles[leftIndex] instanceof WoodTile || allTiles[leftIndex] instanceof WoodTile2 || allTiles[leftIndex] instanceof Log1);
        boolean hasRightNeighbor = originalX < width - 1 && 
                                  (allTiles[rightIndex] instanceof WoodTile || allTiles[rightIndex] instanceof WoodTile2 || allTiles[rightIndex] instanceof Log1);

        // Atribui a sprite com base nas combinações
        if (hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = WOOD2_WITH_LEFT_RIGHT;
        } else if (hasLeftNeighbor) {
            this.sprite = WOOD2_WITH_LEFT;
        } else if (hasRightNeighbor) {
            this.sprite = WOOD2_WITH_RIGHT;
        } else {
            this.sprite = WOOD2_ALONE;
        }
    }
}