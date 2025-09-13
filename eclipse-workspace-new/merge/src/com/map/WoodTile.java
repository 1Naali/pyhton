package com.map;

import java.awt.image.BufferedImage;
import com.main.GameMain;

public class WoodTile extends Tile {

    private Tile[] allTiles;
    private int width;
    private int height;
    private int originalX, originalY;

    // Sprites adaptadas para não considerar a direção "Baixo"
    private static BufferedImage WOOD_ALONE;
    private static BufferedImage WOOD_WITH_UP;
    private static BufferedImage WOOD_WITH_LEFT;
    private static BufferedImage WOOD_WITH_RIGHT;
    private static BufferedImage WOOD_WITH_UP_LEFT;
    private static BufferedImage WOOD_WITH_UP_RIGHT;
    private static BufferedImage WOOD_WITH_LEFT_RIGHT;
    private static BufferedImage WOOD_WITH_UP_LEFT_RIGHT;

    static {
        WOOD_ALONE = GameMain.sg.getSprite(0, 0, 32, 32); 
        WOOD_WITH_UP = GameMain.sg.getSprite(0, 0, 32, 32);
        WOOD_WITH_LEFT = GameMain.sg.getSprite(64, 64, 32, 32);
        WOOD_WITH_RIGHT = GameMain.sg.getSprite(0, 64, 32, 32);
        WOOD_WITH_UP_LEFT = GameMain.sg.getSprite(64, 96, 32, 32);
        WOOD_WITH_UP_RIGHT = GameMain.sg.getSprite(0, 96, 32, 32);
        WOOD_WITH_LEFT_RIGHT = GameMain.sg.getSprite(32, 64, 32, 32);
        WOOD_WITH_UP_LEFT_RIGHT = GameMain.sg.getSprite(32, 96, 32, 32);
    }

    public WoodTile(int x, int y, BufferedImage sprite, Tile[] allTiles, int mapWidth, int mapHeight) {
        super(x, y, sprite);
        this.originalX = x / 32;
        this.originalY = y / 32;
        this.allTiles = allTiles;
        this.width = mapWidth;
        this.height = mapHeight;
    }

    public void initializeSprite() {
        // Obtem as coordenadas dos vizinhos (4 direções)
        int upIndex = (originalY - 1) * width + originalX;
        int leftIndex = originalY * width + (originalX - 1);
        int rightIndex = originalY * width + (originalX + 1);

        // Verificando os vizinhos de Cima, Esquerda e Direita
        boolean hasUpNeighbor = originalY > 0 && allTiles[upIndex] instanceof WoodTile;
        boolean hasLeftNeighbor = originalX > 0 && allTiles[leftIndex] instanceof WoodTile;
        boolean hasRightNeighbor = originalX < width - 1 && allTiles[rightIndex] instanceof WoodTile;

        // Atribui a sprite com base nas combinações
        if (hasUpNeighbor && hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = WOOD_WITH_UP_LEFT_RIGHT;
        } else if (hasUpNeighbor && hasLeftNeighbor) {
            this.sprite = WOOD_WITH_UP_LEFT;
        } else if (hasUpNeighbor && hasRightNeighbor) {
            this.sprite = WOOD_WITH_UP_RIGHT;
        } else if (hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = WOOD_WITH_LEFT_RIGHT;
        } else if (hasUpNeighbor) {
            this.sprite = WOOD_WITH_UP;
        } else if (hasLeftNeighbor) {
            this.sprite = WOOD_WITH_LEFT;
        } else if (hasRightNeighbor) {
            this.sprite = WOOD_WITH_RIGHT;
        } else {
            this.sprite = WOOD_ALONE;
        }
    }
}