package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import Misc.Bomb;
import render.ResourceLoader;


public class BombHandler implements KeyListener{

	public Bomb[] bombArray = new Bomb[16];
	int playerPosX, playerPosY = 0;
	public BufferedImage bombTile = ResourceLoader.ladeBild("/bomb.png");
	public int stunTimer = 0;

	public void incBombTimer() {
		if(stunTimer < 0) {

			stunTimer--;

		}else stunTimer = 0;

		for(int i = 0; i < 16; i++) {

			if(bombArray[i] != null) {

				bombArray[i].incBombTimer();

			}

		}

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



	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_SPACE) {

			if(stunTimer == 0) {

				for(int i = 0; i < 16; i++) {

					if(bombArray[i] == null ) {

						bombArray[i] = new Bomb(Misc.Utils.RoundNumberToMultipleOf64(playerPosX), Misc.Utils.RoundNumberToMultipleOf64(playerPosY) );
						stunTimer = 32;
						return;

					}

					if(bombArray[i].getUsed() == false) {
						bombArray[i] = new Bomb(Misc.Utils.RoundNumberToMultipleOf64(playerPosX), Misc.Utils.RoundNumberToMultipleOf64(playerPosY) );
 
						stunTimer = 32;
						return;

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
