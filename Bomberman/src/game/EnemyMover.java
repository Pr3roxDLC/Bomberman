package game;


import Misc.Enemy;

public class EnemyMover {


	public Enemy[] enemyArray = new Enemy[16];
	public int[][] tileIDArray = new int[30][16];
	public int ammount = 0;
	public int numberOfLivingEnemies = 0;
	
	public int getNumberOfLivingEnemies() {
		
		numberOfLivingEnemies = 0;
		
		for(int i = 0; i < ammount; i++) {
			if(enemyArray[i] != null) {

				numberOfLivingEnemies++;
				
			}
		}
		
		return numberOfLivingEnemies;
		
	}

	public void setTileIDArray(int[][] tileIDArray) {

		this.tileIDArray = tileIDArray;

	}
	public void setAmmount(int ammount) {

		this.ammount = ammount;

	}

	public Enemy[] getEnemyArray() {

		return enemyArray;

	}

	public void checkColWithExplosion(int[][] FXArray) {

		for(int i = 0; i < 16; i++) {
			if(enemyArray[i] != null) {

				if(FXArray[enemyArray[i].getX() / 64][enemyArray[i].getY() / 64] != 7) {

					enemyArray[i] = null;
				}
			}

		}

	}


	public Enemy getEnemyFromArray(int enemyPosInEnemyArray) {

		return enemyArray[enemyPosInEnemyArray];

	}

	public int getAmmount() {

		return ammount;

	}


	public void moveEnemies() {


		for(int i = 0; i < ammount; i++) {
			if(enemyArray[i] != null) {

				enemyArray[i].moveEnemy();
			}	
		}

	}

	public void setEnemyTileIDArrayForEachEnemy(int[][] tileIDArray) {

		for(int i = 0; i < ammount; i++) {

			if(enemyArray[i] != null) enemyArray[i].setTileIDArray(tileIDArray);

		}

	}


	public void spawnEnemies() {

		for(int i = 0; i < ammount; i++) {
			if(enemyArray[i] != null)	enemyArray[i] = null;

		}

		for(int i = 0; i <= ammount; i++) {

			int randX = (int) Misc.Utils.random(27, 1);
			int randY = (int) Misc.Utils.random(15, 1);
			int randTile = (int) Misc.Utils.random(0, 3);
			//	System.out.println(i);
			if(tileIDArray[randX][randY] == 0) {

				enemyArray[i] = new Enemy(randX * 64, randY * 64, randTile);

			}else {

				i--;

			}




		}

		System.out.println("[EnemyMover]: Finished Spawning Enemies");


	}

}