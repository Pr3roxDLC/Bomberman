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

	// no movement, up, left, down, right
	int executingDirection = 0;
	// current steps between tiles
	int stepCounter = 0;
	//skrt
	/*
	 * Spieler soll sich tile für tile bewegen
	 * Wird bspw d gedrückt, läuft er ein ganzes Teil nach recht, egal was danach gedrückt wird
	 */
	public void movePlayer() {
		// accept new input
		if (executingDirection == 0) {
			if (bUp) {
				executingDirection = 1;
			}
			if (bLeft) {
				executingDirection = 2;
			}
			if (bDown) {
				executingDirection = 3;
			}
			if (bRight) {
				executingDirection = 4;
			}
		}

		// move player
		if (executingDirection != 0) {
			switch (executingDirection) {
			case 1:
				playerPosY -= playerSpeed;
				break;
			case 2:
				playerPosX -= playerSpeed;
				break;
			case 3:
				playerPosY += playerSpeed;
				break;
			case 4:
				playerPosX += playerSpeed;
				break;
			default:
				break;
			}

			// increase step counter
			stepCounter++;
		}

		// reset executing direction if neccesary
		if (stepCounter == 8) {
			stepCounter = 0;
			executingDirection = 0;
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
