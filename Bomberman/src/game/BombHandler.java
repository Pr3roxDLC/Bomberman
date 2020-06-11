package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import Misc.Bomb;
import render.ResourceLoader;


public class BombHandler implements KeyListener{

	public Bomb[] bombArray = new Bomb[16];
	public int[][] tileIDArray = new int[30][16];
	public int totalBombsOnScreen = 0;
	int playerPosX, playerPosY = 0;
	public BufferedImage bombTile = ResourceLoader.ladeBild("/bomb.png");
	public int stunTimer = 0;
	int radius = 1;
	int maxBombs = 0;

	public void setMaxBombs(int maxBombs) {

		this.maxBombs = maxBombs;

	}

	public void incBombTimer() {
		if(stunTimer > 0) {

			stunTimer--;

		}
		totalBombsOnScreen = 0;
		for(int i = 0; i < 16; i++) {

			if(bombArray[i] != null) {
				totalBombsOnScreen ++;
				bombArray[i].incBombTimer();	
				if(bombArray[i].getUsed() == false) {
					totalBombsOnScreen--;
					bombArray[i] = null;
				}

			}

		}

		//		System.out.println(totalBombsOnScreen);

	}

	public int[][] updateTileIDArray() {

		return tileIDArray;		
	}



	public BufferedImage getBombTile() {
		return bombTile;


	}




	public Bomb[] getBombArray() {

		return bombArray;

	}

	//Needs to be called every Frame
	public void setPlayerPos(int playerPosX, int playerPosY) {


		this.playerPosX = playerPosX;
		this.playerPosY = playerPosY;


	}
	public void setRadius(int radius) {

		this.radius = radius;

	}







	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		//	System.out.println(stunTimer );
			if(stunTimer == 0) {




				for(int i = 0; i < 16; i++) {
					if(maxBombs > totalBombsOnScreen) {

						if(bombArray[i] == null && stunTimer == 0) {

							bombArray[i] = new Bomb(Misc.Utils.RoundNumberToMultipleOf64(playerPosX), Misc.Utils.RoundNumberToMultipleOf64(playerPosY), radius );
//							System.out.println("Bomb");
							stunTimer = 16;
							return;

						}

						if(bombArray[i].getUsed() == false && stunTimer == 0) {
							bombArray[i] = new Bomb(Misc.Utils.RoundNumberToMultipleOf64(playerPosX), Misc.Utils.RoundNumberToMultipleOf64(playerPosY), radius);
//							System.out.println("bomb");
							stunTimer = 16;
							return;

						}
					}

				}


			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
