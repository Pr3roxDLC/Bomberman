package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMover implements KeyListener{

	int playerPosX = 0;
	int playerPosY = 0;
	int playerSpeed = 8;
	boolean bDown,bUp,bLeft,bRight = false;
	int stepCount = 0;
	int direction = 1;

	public void movePlayer() {
		if(stepCount == 0) {
			if (bDown == true) {
				direction = 1;
				stepCount = stepCount + 1;
				playerPosY = playerPosY+playerSpeed;

			}
			if (bUp == true) {
				direction = 2;
				stepCount = stepCount + 1;
				playerPosY = playerPosY-playerSpeed;


			}
			if (bLeft == true) {
				direction = 3;
				stepCount = stepCount + 1;
				playerPosX = playerPosX-playerSpeed;

			}
			if (bRight == true) {
				direction = 4;
				stepCount = stepCount + 1;
				playerPosX = playerPosX+playerSpeed;

			}
		}else {
			switch(direction ) {

			case 1: 
				stepCount = stepCount + 1;
				playerPosY = playerPosY+playerSpeed;
				break;

			case 2:
				stepCount = stepCount + 1;
				playerPosY = playerPosY-playerSpeed;
				break;

			case 3:
				stepCount = stepCount + 1;
				playerPosX = playerPosX-playerSpeed;
				break;

			case 4:
				stepCount = stepCount + 1;
				playerPosX = playerPosX+playerSpeed;
				break;
			}
		}

		if(stepCount == 8) {
			stepCount = 0;
		}
	}
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode()==KeyEvent.VK_DOWN) {		
			bDown = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			bUp = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			bRight = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			bLeft = true;
		}	
		if(stepCount == 7) {
			stepCount = 0;
		}
	}


	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {		
			bDown = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			bUp = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			bRight = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			bLeft = false;

		}
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


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
