package game;

import Misc.Enemy;

public class PlayerDeathTiles {

	public static boolean[][] deathTileIDArray = new boolean[30][16];

	public static void addEnemiesToDeathArray(Enemy[] e) {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 16; j++) {
				
				deathTileIDArray[i][j] = false;
				
			}
			
			
		}
		

		for(int i = 0; i < e.length; i++) {
			
			if(e[i] != null) {

			deathTileIDArray[e[i].getX() / 64][e[i].getY() / 64] = true;
			
			
			
			}
		}	
	}



	public static void addExplosionsToDeathArray(int[][] FXArray) {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 16; j++) {

				if(FXArray[i][j] != 7 )	{

					deathTileIDArray[i][j] = true;

				}

			}
		}




	}



	public static boolean playerIsOnDeathTile(int playerPosX, int playerPosY) {

		int playerPosAsTilePosX = playerPosX/64;
		int playerPosAsTilePosY = playerPosY/64;

		if(deathTileIDArray[playerPosAsTilePosX][playerPosAsTilePosY] == true) {
			//System.out.println("DEATH");
			return true;

		}else {
			//System.out.println("ALIVE");
			return false;
		}

	}




}
