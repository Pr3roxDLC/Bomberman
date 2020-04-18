package game;


import java.awt.image.BufferedImage;

import Misc.Enemy;

public class EnemyMover {


	public Enemy[] enemyArray = new Enemy[16];
	public int[][] tileIDArray = new int[30][16];
	public int ammount = 0;

	public void setTileIDArray(int[][] tileIDArray) {

		this.tileIDArray = tileIDArray;

	}
	public void setAmmount(int ammount) {

		this.ammount = ammount;

	}


	public Enemy getEnemyFromArray(int enemyPosInEnemyArray) {

		return enemyArray[enemyPosInEnemyArray];

	}
	
	public int getAmmount() {
		
		return ammount;
		
	}
	

	public void moveEnemies() {
		
		for(int i = 0; i < ammount; i++) {

			enemyArray[i].moveEnemy();
			
		}
		
	}
	
	public void setEnemyTileIDArrayForEachEnemy(int[][] tileIDArray) {
		
		for(int i = 0; i < ammount; i++) {
			
			enemyArray[i].setTileIDArray(tileIDArray);
			
		}
		
	}


	public void spawnEnemies() {

		for(int i = 0; i < 16; i++) {
			enemyArray[i] = null;

		}

		for(int i = 0; i <= ammount; i++) {

			int randX = (int) Misc.Utils.random(27, 1);
			int randY = (int) Misc.Utils.random(15, 1);
			int randTile = (int) Misc.Utils.random(0, 3);
			System.out.println(i);
			if(tileIDArray[randX][randY] == 0) {

				enemyArray[i] = new Enemy(randX * 64, randY * 64, randTile);
				
			}else {
				
				i--;
				
			}
			



		}
		
		System.out.println("Finished Spawning Enemies");


	}

}