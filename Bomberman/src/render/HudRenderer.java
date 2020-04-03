package render;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class HudRenderer {


	public BufferedImage hudTile = null;
	public int score = 0;
	public Graphics gHud;
	public Image completeHud = null;
	public boolean gamePaused = false;

	//Loads The Tile Used for the HUD/Score Area Background
	public void initHud() {
		System.out.println("[Hud Renderer]: Started Init Sequence");


		hudTile = ResourceLoader.ladeBild("/Dev2.png");

		System.out.println("[Hud Renderer]: Completed Init Sequence");
	}
	// Returns the Hud Tile, Will be Changed later, if the scoreboard either gets a single texture or if it gets made up from differen textures
	public BufferedImage getHudTile() {


		return hudTile;
	}
	//Getter and Setters For the Score Printed out on the Screen
	public int getScore() {

		return score;

	}

	public void setGamePaused(boolean gamePaused) {
		
		this.gamePaused = gamePaused;
		
	}
	
	public boolean getGamePaused() {
		
		return gamePaused;
		
	}
	
	public void setScore(int score) {

		this.score = score;


	}


}




