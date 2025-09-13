package com.map;

import java.awt.image.BufferedImage;
import com.main.GameMain;

public class WaterTile extends Tile {

    public static BufferedImage[] waterSprites;
    private int animationTick = 0;
    private int animationSpeed = 12; // Velocidade da animação (quanto menor, mais rápida)
    private int animationIndex = 0;

    public WaterTile(int x, int y, BufferedImage sprite) {
        super(x, y, sprite);

        waterSprites = new BufferedImage[8];
        waterSprites[0] = GameMain.sg.getSprite(96, 0, 32, 32);
        waterSprites[1] = GameMain.sg.getSprite(128, 32, 32, 32);
        waterSprites[2] = GameMain.sg.getSprite(128, 0, 32, 32);
        waterSprites[3] = GameMain.sg.getSprite(96, 32, 32, 32);
        waterSprites[4] = GameMain.sg.getSprite(96, 0, 32, 32);
        waterSprites[5] = GameMain.sg.getSprite(128, 64, 32, 32);
        waterSprites[6] = GameMain.sg.getSprite(160, 0, 32, 32);
        waterSprites[7] = GameMain.sg.getSprite(96, 64, 32, 32);
    }

    @Override
    public void tick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= waterSprites.length) {
                animationIndex = 0;
            }

            this.sprite = waterSprites[animationIndex];
        }
    }
}