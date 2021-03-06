package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//LEO

public class PlayerMover implements KeyListener {

	int playerPosX = (1 * 64);
	int playerPosY = (2 * 64);
	int playerSpeed = 4;
	boolean bDown, bUp, bLeft, bRight = false;
	int stepCount = 0;
	boolean collision = false;
	public int[][] tileIDArray = new int[30][16];
	// no movement, up, left, down, right
	int executingDirection = 0;
	// current steps between tiles
	int stepCounter = 0;
	int collisionTileX, collisionTileY;
	public boolean blockPlayerInputs = false;


	/*
	 * Spieler soll sich tile f�r tile bewegen
	 * Wird bspw d gedr�ckt, l�uft er ein ganzes Teil nach recht, egal was danach gedr�ckt wird
	 */



	public int getTileID(int xPos, int yPos) {
		return tileIDArray[xPos][yPos];
	}

	public void setTileIDArray(int[][] tileIDArray) {
		this.tileIDArray = tileIDArray;
	}

	public int getplayerDirection() {
		return executingDirection;
	}


	//Checks if the Tile the player tries to move to is a Wall (tileID 2) or a Crate(tileID 3)
	public boolean detectCollision() {
		if ((playerPosX % 64 == 0) && (playerPosY % 64 == 0)) {
			switch (executingDirection) {
			case 0:
				break;
			case 1:
				collisionTileX = playerPosX / 64;
				collisionTileY = (playerPosY / 64) - 1;
				if (tileIDArray[collisionTileX][(collisionTileY)] == 2 || tileIDArray[collisionTileX][(collisionTileY)] == 3) {
					executingDirection = 0;
					return true;
				}
				return false;
			case 2:
				if (tileIDArray[(playerPosX / 64) - 1][playerPosY / 64] == 2 || tileIDArray[(playerPosX / 64) - 1][playerPosY / 64] == 3) {
					executingDirection = 0;
					return true;
				}
				return false;
			case 3:
				if (tileIDArray[playerPosX / 64][(playerPosY / 64) + 1] == 2 || tileIDArray[playerPosX / 64][(playerPosY / 64) + 1] == 3) {
					executingDirection = 0;
					return true;
				}
				return false;
			case 4:
				if (tileIDArray[(playerPosX / 64) + 1][playerPosY / 64] == 2 || tileIDArray[(playerPosX / 64) + 1][playerPosY / 64] == 3) {
					executingDirection = 0;
					return true;
				}
				return false;
			}
			return false;
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
		//Check if player colliding with wall
		collision = detectCollision();
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
		if (stepCounter == 64 / playerSpeed) {
			stepCounter = 0;
			executingDirection = 0;
		}

	}

	public void setPlayerPos(int x, int y) {

		playerPosX = x;
		playerPosY = y;
		executingDirection = 0;

	}
	
	public void setBlockPlayerInputs(boolean bool) {
		
		blockPlayerInputs = bool;
		
		bDown = false;
		bUp = false;
		bLeft = false;
		bRight = false;
		executingDirection = 0;
		stepCount = 0;
		stepCounter = 0;
		
	}



	public void keyPressed(KeyEvent e) {
		if(!blockPlayerInputs) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				bDown = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				bUp = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				bRight = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				bLeft = true;
			}
		}
	}


	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			bDown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			bUp = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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