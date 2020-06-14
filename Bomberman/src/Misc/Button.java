package Misc;

import java.awt.image.BufferedImage;



//TIM

public class Button {
	
	//TODO add Animation when Clicked/Hovered
	
	public BufferedImage buttonTile = null;
	public int getPosX() {
		return posX;
	}




	public void setPosX(int posX) {
		this.posX = posX;
	}




	public int getPosY() {
		return posY;
	}




	public void setPosY(int posY) {
		this.posY = posY;
	}




	public int getWidth() {
		return width;
	}




	public void setWidth(int width) {
		this.width = width;
	}




	public int getHeight() {
		return height;
	}




	public void setHeight(int height) {
		this.height = height;
	}




	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}




	public boolean isHidden() {
		return isHidden;
	}





	public int posX = 0;
	public int posY = 0;
	public int width = 0;
	public int height = 0;
	public boolean isHidden = false;
	public String text = "";
	
	
	
	public void setHidden(boolean isHidden) {
		
		this.isHidden = isHidden;
		
	}
	
	
	

	public Button(String text, int posX, int posY, int width, int height, boolean isHidden){
		
		
		this.text = text;
		this.posX = posX;
		this.posY  = posY;
		this.width = width;
		this.height = height;
		this.isHidden = isHidden;
		
		
	}
	
	
	
	
	

	
	

}
