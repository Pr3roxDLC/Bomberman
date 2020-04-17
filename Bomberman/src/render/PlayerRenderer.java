package render;

import java.awt.Image;
import java.awt.image.BufferedImage;


public class PlayerRenderer {

	BufferedImage player = null;
	int playerPosX = (1*64); 
	int playerPosY = (2*64);
	int playerSpeed = 1;
	boolean visible = true;
	Image i = null;

	//TIM

	public void initPlayer() {
		System.out.println("[Player Renderer]: Started Init Sequence");

		player = ResourceLoader.ladeBild("/anim/player/PlayerSpriteSouth2.png");


		System.out.println("[Player Renderer]: Loaded Player Tile");

		System.out.println("[Player Renderer]: Completed Init Sequence");

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
}


