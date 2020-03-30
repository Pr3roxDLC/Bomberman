package render;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class HudRenderer {
	
	
	public BufferedImage hudTile = null;
	public int score = 0;
	public Graphics gHud;
	public Image completeHud = null;
	
	
	public void initHud() {
		
		
		hudTile = ResourceLoader.ladeBild("/res/Dev2.png");
	
	
	}
	
	public BufferedImage getHudTile() {
		
		
		return hudTile;
	}
	
	
	public void setScore(int score) {
		
		this.score = score;
		
		
	}
	
	public Graphics createHud() {
		
		
		
		for(int i = 0; i > 30; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				gHud.drawImage(hudTile, (i * 64), (j * 64), null);
				
			}
			
		}
		
		
	

		
		
		return gHud;
		
		
		
		
	}
	
	
	
}
