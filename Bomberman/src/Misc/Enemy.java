package Misc;

import java.awt.image.BufferedImage;


import render.ResourceLoader;

public class Enemy {

	int x,y = 0;
	int dir;
	public BufferedImage enemyTile = null;
	public int[][] tileIDArray = new int[30][16];

	boolean isMoving = false;
	boolean isLiving = true;
	int stepsLeft = 0;

	public void setTileIDArray(int[][] tileIDArray) {

		this.tileIDArray = tileIDArray;

	}


	public void moveEnemy() {

		if(stepsLeft <= 0) {
			
			isMoving = false;
			
		}
		
		if(isMoving == false) {
			
			

			dir = Misc.Utils.random(0, 4);
			System.out.println(dir);
			isMoving = true;
			int i = 0;
			stepsLeft = stepsLeft - 16;
			switch (dir) {
			case 0:
				while(tileIDArray[(x/64)][(y/64) - i] == 0) {
					stepsLeft = stepsLeft + 16;
					System.out.println("Checked Up");
					i++;
				}
				break;
			case 1:
				while(tileIDArray[(x/64) + i][(y/64)] == 0) {
					stepsLeft = stepsLeft + 16;
					System.out.println("Checked Right");
					i++;
				}
				break;

			case 2:
				while(tileIDArray[(x/64)][(y/64) + i] == 0) {
					stepsLeft = stepsLeft + 16;
					System.out.println("Checked Down");
					i++;
				}
				break;

			case 3:
				while(tileIDArray[(x/64) - i][(y/64)] == 0) {
					stepsLeft = stepsLeft + 16;
					System.out.println("Checked Left");
					i++;
				}
				break;


			default:
				while(tileIDArray[(x/64)][(y/64) - i] == 0) {
					stepsLeft = stepsLeft + 16;
					System.out.println("Checked Down");
					i++;
				}
				break;
			}

		}
		if(stepsLeft > 0) {
			
			System.out.println("Tried Moving");
			switch(dir) {
			case 0:
				y = y - 4;
				stepsLeft--;
				break;
			case 1:
				x = x + 4;
				stepsLeft--;
				break;
			case 2:
				y = y + 4;
				stepsLeft--;
				break;
			case 3:
				x = x - 4;
				stepsLeft--;
				break;
			default:
				y = y - 4;
				stepsLeft--;
				break;



			}

		}
		
			
			
	


	}

	public BufferedImage getEnemyTile() {

		return enemyTile;

	}

	public int getX() {

		return x;

	}

	public int getY() {

		return y;

	}






	public Enemy(int x, int y, int enemyTileID) {

		this.x = x;
		this.y = y;

		switch (enemyTileID) {
		case 0:
			enemyTile = ResourceLoader.ladeBild("/Red.png");
			break;
		case 1:
			enemyTile = ResourceLoader.ladeBild("/Blue.png");
			break;
		case 2:
			enemyTile = ResourceLoader.ladeBild("/Green.png");
			break;


		default:

			enemyTile = ResourceLoader.ladeBild("/Red.png");

			break;
		}

	}

}
