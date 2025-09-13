package com.map;

import java.awt.image.BufferedImage;
import com.main.GameMain;

public class FloorTile extends Tile {

    private Tile[] allTiles;
    private int width;
    private int height;
    private int originalX, originalY;

    // Defina as sprites para cada combinação de vizinhos
    private static BufferedImage FLOOR_WITH_UP_WALL; 
    private static BufferedImage FLOOR_WITH_DOWN_WALL;
    private static BufferedImage FLOOR_WITH_LEFT_WALL;
    private static BufferedImage FLOOR_WITH_RIGHT_WALL;
    private static BufferedImage FLOOR_WITH_UP_DOWN_WALL;
    private static BufferedImage FLOOR_WITH_LEFT_RIGHT_WALL;
    private static BufferedImage FLOOR_WITH_CORNER;
    private static BufferedImage FLOOR_ALONE; 
    
    // Você deve preencher as coordenadas X e Y das suas sprites aqui
    static {
        FLOOR_WITH_UP_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_DOWN_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_LEFT_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_RIGHT_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_UP_DOWN_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_LEFT_RIGHT_WALL = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_WITH_CORNER = GameMain.sg.getSprite(0, 0, 32, 32); 
        FLOOR_ALONE = GameMain.sg.getSprite(0, 0, 32, 32); 
    }

    public FloorTile(int x, int y, BufferedImage sprite, Tile[] allTiles, int mapWidth, int mapHeight) {
        super(x, y, sprite);
        this.originalX = x / 32;
        this.originalY = y / 32;
        this.allTiles = allTiles;
        this.width = mapWidth;
        this.height = mapHeight;
    }

    @Override
    public void tick() {
        // Obter as coordenadas dos vizinhos
        int upX = originalX;
        int upY = originalY - 1;

        int downX = originalX;
        int downY = originalY + 1;

        int leftX = originalX - 1;
        int leftY = originalY;

        int rightX = originalX + 1;
        int rightY = originalY;

        // Verificar a existência e tipo dos vizinhos
        boolean hasUpNeighbor = false;
        if (upY >= 0 && upY < height) {
            Tile neighbor = allTiles[upX + (upY * width)];
            if (neighbor instanceof FloorTile) {
                hasUpNeighbor = true;
            }
        }

        boolean hasDownNeighbor = false;
        if (downY >= 0 && downY < height) {
            Tile neighbor = allTiles[downX + (downY * width)];
            if (neighbor instanceof FloorTile) {
                hasDownNeighbor = true;
            }
        }

        boolean hasLeftNeighbor = false;
        if (leftX >= 0 && leftX < width) {
            Tile neighbor = allTiles[leftX + (leftY * width)];
            if (neighbor instanceof FloorTile) {
                hasLeftNeighbor = true;
            }
        }

        boolean hasRightNeighbor = false;
        if (rightX >= 0 && rightX < width) {
            Tile neighbor = allTiles[rightX + (rightY * width)];
            if (neighbor instanceof FloorTile) {
                hasRightNeighbor = true;
            }
        }

        // Definir a sprite com base nos vizinhos
        if (hasUpNeighbor && hasDownNeighbor) {
            this.sprite = FLOOR_WITH_UP_DOWN_WALL;
        } else if (hasLeftNeighbor && hasRightNeighbor) {
            this.sprite = FLOOR_WITH_LEFT_RIGHT_WALL;
        } else if (hasUpNeighbor) {
            this.sprite = FLOOR_WITH_UP_WALL;
        } else if (hasDownNeighbor) {
            this.sprite = FLOOR_WITH_DOWN_WALL;
        } else if (hasLeftNeighbor) {
            this.sprite = FLOOR_WITH_LEFT_WALL;
        } else if (hasRightNeighbor) {
            this.sprite = FLOOR_WITH_RIGHT_WALL;
        } else {
            this.sprite = FLOOR_ALONE;
        }
        
    }
}