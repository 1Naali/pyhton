package signup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanelGradient extends JPanel {

	
	public PanelGradient() {
		setOpaque(false);
		colors = new ArrayList<>();
	}
	
	private List<ModelColor> colors;
	
	public void addColor(ModelColor ...color) {
		for(ModelColor c:color) {
			colors.add(c);
		}
	}
	
	protected void paintComponent(Graphics grphcs) {
		
		if(!colors.isEmpty()) {
			int width = getWidth();
			int height = getHeight();
			Graphics2D g2 = (Graphics2D) grphcs;
			Color color[] = new Color[colors.size()];
			float position[] = new float[colors.size()];
			for(int i = 0; i < colors.size(); i++) {
				color[i] = colors.get(i).getColor();
				position[i] = colors.get(i).getPosition();
			}
			int sx = 0,sy = 0;
			int ex = width;
			int ey = height;
			LinearGradientPaint g = new LinearGradientPaint(sx,sy,ex,ey,position,color);
			g2.setPaint(g);
			g2.fillRect(0, 0, width, height);
		}
		
		super.paintComponent(grphcs);
		
		
		
	}

}
