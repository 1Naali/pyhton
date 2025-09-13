package com.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;
import com.player.Entity;

public class Entity {

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	public int depth;
		
	public boolean debug = false;
	
	private BufferedImage sprite;
	
	public Entity(double x,double y,int width,int height,int depth,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		this.depth = depth;
	}
	
	public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {
		
		@Override
		
		public int compare(Entity n0, Entity n1) {
			if(n1.depth < n0.depth) {
				return +1;
			}
			if(n1.depth > n0.depth) {
				return -1;
			}
			return 0;
		}
		
	};
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite,this.getX() - com.hud.Camera.x,this.getY() - com.hud.Camera.y,null);
	}
}	