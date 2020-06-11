package game;

import render.ExplosionFX;

public class ExplosionHandler {

	public static int[][] tileIDArray = new int[30][16];
	static boolean endLoop = false;

	public static void setTileIDArray(int[][] tileIDArray) {

		ExplosionHandler.tileIDArray = tileIDArray;

	}





	public static void explode(int bombPosX, int bombPosY, int radius) {

		//System.err.println("Called");

		int bombPosAsTilePosX, bombPosAsTilePosY = 0;
		int down = 0, up = 0, left = 0, right = 0;


		bombPosAsTilePosX = bombPosX / 64;
		bombPosAsTilePosY = bombPosY / 64;


		endLoop = false;
		//Check if explosion should be vertical			
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosX - i < 30) {
				right = i;

				if(tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] == 3) {

					tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] = 0;
					break;

				}
				if(tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] == 2) {
					right--;
					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {	
			if(bombPosAsTilePosX - i > 0) {
				left = i;

				if(tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] == 3) {

					tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] == 2) {
					left--;
					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosY - i < 30) {
				up = i;

				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + i] == 3) {

					tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + i] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + 1] == 2) {
					up--;
					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosY - i >= 0) {
				down = i;

				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - i] == 3) {

					tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - i] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - 1] == 2) {
					down--;
					break;
				}

			}
		}

		if(down < 0) {
			down = 0;

		}
		if(left < 0) {
			left = 0;

		}

		if(up < 0) {
			up = 0;

		}

		if(right < 0) {
			right = 0;

		}


		ExplosionFX.addExplosion(bombPosAsTilePosX, bombPosAsTilePosY, down, up, left, right);


	}

	public static int[][] getTileIDArray(){

		return tileIDArray;

	}



}
