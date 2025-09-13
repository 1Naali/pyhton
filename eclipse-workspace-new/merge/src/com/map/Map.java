// Map.java
package com.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
	
	private static Tile[] backgroundTiles;
	private static Tile[] foregroundTiles;
	private static int WIDTH,HEIGHT;
	private static final int TILE_SIZE = 32;
	
	public Map(String path) {
		try {
			BufferedImage mapping = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[mapping.getWidth() * mapping.getHeight()];
			WIDTH = mapping.getWidth();
			HEIGHT = mapping.getHeight();
			backgroundTiles = new Tile[mapping.getWidth() * mapping.getHeight()];
			foregroundTiles = new Tile[mapping.getWidth() * mapping.getHeight()];
			
			mapping.getRGB(0, 0, mapping.getWidth(), mapping.getHeight(), pixels, 0, mapping.getWidth());
			
			for(int xx = 0; xx < mapping.getWidth(); xx++){
				for(int yy = 0; yy < mapping.getHeight(); yy++){
					int pixelAtual = pixels[xx + (yy * mapping.getWidth())];
					
					// Define uma tile de fundo padrão para todas as posições
					backgroundTiles[xx + (yy * WIDTH)] = new WaterTile(xx * 32, yy * 32, Tile.WATERMAIN);
					
					switch(pixelAtual) {
					case 0xFF00FF00: // Verde: WoodTile
					   
					    foregroundTiles[xx + (yy * WIDTH)] = new WoodTile(xx * 32, yy * 32, Tile.WOOD, foregroundTiles, WIDTH, HEIGHT);
					    
					break;
					
					case 0xFF000000: // Preto: Água
						
						foregroundTiles[xx + (yy * WIDTH)] = null;
						
					break;
					
					case 0xFF007F0E: // Parte de baixo da madeira
						
						foregroundTiles[xx + (yy * WIDTH)] = new WoodTile2(xx * 32, yy * 32, Tile.WOOD2, foregroundTiles, WIDTH, HEIGHT);
						
					break;
					
					
					case 0xFFFF0000:
						
						 foregroundTiles[xx + (yy * WIDTH)] = new Log1(xx * 32, yy * 32, Tile.LOG1_DEFAULT, foregroundTiles, WIDTH, HEIGHT);
						
					break;
					
					}
				}
			}
			
			// Segundo loop: inicializa as sprites das WoodTiles agora que todas as tiles foram criadas
			for(int i = 0; i < foregroundTiles.length; i++){
			    if(foregroundTiles[i] instanceof WoodTile){
			        ((WoodTile) foregroundTiles[i]).initializeSprite();
			    } else if (foregroundTiles[i] instanceof WoodTile2) {
			        ((WoodTile2) foregroundTiles[i]).initializeSprite();
			    }else if (foregroundTiles[i] instanceof Log1) {
			        ((Log1) foregroundTiles[i]).initializeSprite();
			    }
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
	    for (int i = 0; i < backgroundTiles.length; i++) {
	        if (backgroundTiles[i] instanceof WaterTile) {
	            WaterTile waterTile = (WaterTile) backgroundTiles[i];
	            waterTile.tick();
	        }
	    }
	}
	
	public void render(Graphics g){
	    for(int i = 0; i < backgroundTiles.length; i++) { 
	        Tile tile = backgroundTiles[i];
	        if (tile != null) {
	            tile.render(g);
	        }
	    }
	    
	    for(int i = 0; i < foregroundTiles.length; i++) { 
	        Tile tile = foregroundTiles[i];
	        if (tile != null) {
	            tile.render(g);
	        }
	    }
	}
}