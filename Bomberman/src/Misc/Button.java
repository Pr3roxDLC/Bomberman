package Misc;

import java.awt.image.BufferedImage;

import render.ResourceLoader;

public class Button {
	
	public BufferedImage buttonTile = null;
	public int posX = 0;
	public int posY = 0;
	
	
	
	
	
	
	public Button(String str, int posX, int posY){
		
		
		buttonTile = ResourceLoader.ladeBild(str);
		this.posX = posX;
		this.posY  = posY;
		
	}
	
	

}
