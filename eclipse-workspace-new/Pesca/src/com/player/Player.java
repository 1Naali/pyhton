package com.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hud.Camera;
import com.main.Game;
import com.world.World;

public class Player extends Entity{
	
	private double x = 0,y = 0;
	
	public Player(int x, int y, int width, int height,int depth, BufferedImage sprite) {
		super(x, y, width, height,depth, sprite);
	}
	
	public void updateCamera () {
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2),0,World.WIDTH*16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2),0,World.HEIGHT*16 - Game.HEIGHT);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)(this.getX() - Camera.x), (int)(this.getY() - Camera.y), 10, 20);
		
	}
	
}
