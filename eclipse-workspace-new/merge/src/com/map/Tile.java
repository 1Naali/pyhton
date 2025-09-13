package com.map;

import com.map.Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.main.GameMain;


public class Tile {
	
		protected BufferedImage sprite;
		private int x,y;
		
		public static BufferedImage WATERMAIN = GameMain.sg.getSprite(96,0,32,32);	
		public static BufferedImage WOOD = GameMain.sg.getSprite(32,64,32,32);
		public static BufferedImage WOOD2 = GameMain.sg.getSprite(128, 32, 32, 2);
		public static BufferedImage LOG1_DEFAULT = GameMain.sg.getSprite(0, 0, 32, 32);

		
		
		public Tile(int x,int y,BufferedImage sprite){
			this.x = x;
			this.y = y;
			this.sprite = sprite;
		}
		
		public void tick() {		
		}
		
		public void render(Graphics g){
			g.drawImage(sprite, x, y, null);
		}
		
		

	
}
