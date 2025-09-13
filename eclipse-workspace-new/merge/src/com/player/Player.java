package com.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	private boolean right,up,left,down;
	private double speed = 1.4;
	private int frames = 0,maxFrames = 5,index = 0,maxIndex = 3;
	private boolean moved = false;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private int depth = 1;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
}
