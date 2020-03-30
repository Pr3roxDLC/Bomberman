package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMover implements KeyListener{

	int playerPosX = (1*64);
	int playerPosY = (2*64);
	int playerSpeed = 8;
	boolean bDown,bUp,bLeft,bRight = false;
	int stepCount = 0;
	int direction = 1;
	boolean collision = false;
	public int[][] tileIDArray = new int[30][16]; 
	// no movement, up, left, down, right
	int executingDirection = 0;
	// current steps between tiles
	int stepCounter = 0;

	/*
	 * Spieler soll sich tile für tile bewegen
	 * Wird bspw d gedrückt, läuft er ein ganzes Teil nach recht, egal was danach gedrückt wird
	 */

	public int getTileID(int xPos, int yPos) {
		return tileIDArray[xPos][yPos];
	}

	public void setTileIDArray(int[][] tileIDArray) {
		this.tileIDArray = tileIDArray;
	}

	public boolean detectCollision() {
		System.out.println("Collision check");
		switch (executingDirection) {
		case 0:
			return false;
		case 1:
			System.out.println("Collision check Up");
			if(tileIDArray[playerPosX/64][(playerPosY/64)+1] == 2) {
				System.out.println("Collision detected Up");
				executingDirection = 0;
				return true;
			}
			break;
		case 2:
			System.out.println("Collision check Left");
			if(tileIDArray[(playerPosX/64)-1][playerPosY/64] == 2) {
				System.out.println("Collision detected Left");
				executingDirection = 0;
				return true;
			}
			break;
		case 3:
			System.out.println("Collision check Down");
			if(tileIDArray[playerPosX/64][(playerPosY/64)+1] == 2) {
				System.out.println("Collision detected Down");
				executingDirection = 0;
				return true;
			}
			break;
		case 4:
			System.out.println("Collision check Right");
			if(tileIDArray[(playerPosX/64)+1][playerPosY/64] == 2) {
				System.out.println("Collision detected Right");
				executingDirection = 0;
				return true;
			}
			break;
		
		}
		return false;
	}

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

		collision = detectCollision();

		// move player
		if (executingDirection != 0 && collision == false) {
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
			collision = false;
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
