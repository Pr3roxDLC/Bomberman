package render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerRenderer {
	
	BufferedImage player = null;
	int playerPosX, playerPosY = 0;
	int playerSpeed = 1;
	
	public void initPlayer() {
		
		
		try {
		    player = ImageIO.read(new File("C:\\Users\\Tim\\Desktop\\Dev2.png"));
		} catch (IOException e) {
		}
		
		
	}
	
	
	
	
	
	public BufferedImage getPlayerTile() {
		return player;
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
