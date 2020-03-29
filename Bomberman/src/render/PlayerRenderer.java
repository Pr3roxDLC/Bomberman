package render;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerRenderer {
	
	BufferedImage player = null;
	int playerPosX, playerPosY = 0;
	int playerSpeed = 1;
	boolean visible = true;
	Image i = null;
	
	
	public void initPlayer() {
		
		player = ResourceLoader.ladeBild("/Images/Dev2.png");
  
		
		System.out.println("[Player Renderer]: Loaded Player Tile");
		
		
	}
	
	//Return The Visibility of the Player
	public boolean getVisible() {
		
		return visible;
		
	}
	
	//Set the visibility of the Player
	public void setVisible(boolean bool) {
		
		visible = bool;
		
	}
	
	//Return the player Tile as a BufferedImage
	public BufferedImage getPlayerTile() {
		
		if(visible) {
		return player;
	}else {
		//Return nothing if visible is set to false
		return null;
		
	}
	}





	public void setPlayer(BufferedImage player) {
		this.player = player;
	}





	public int getPlayerPosX() {
		return playerPosX;
	}





	public void setPlayerPosX(int playerPosX) {
		this.playerPosX = playerPosX;
	}





	public int getPlayerPosY() {
		return playerPosY;
	}





	public void setPlayerPosY(int playerPosY) {
		this.playerPosY = playerPosY;
	}





	public int getPlayerSpeed() {
		return playerSpeed;
	}





	public void setPlayerSpeed(int playerSpeed) {
		this.playerSpeed = playerSpeed;
	}





	public void movePlayer(String direction) {
		
		
		switch(direction) {
		case "UP":
			playerPosY = playerPosY + playerSpeed;
			break;
		case "DOWN":
			playerPosY = playerPosY - playerSpeed;
			break;
		case "LEFT":
			playerPosX = playerPosX - playerSpeed;
			break;
		case "RIGHT":
			playerPosX = playerPosX + playerSpeed;
			break;
		
		
		
		}
		
	}

}
