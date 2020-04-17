package game;

public class ExplosionHandler {

	public static int[][] tileIDArray = new int[30][16];
	static boolean endLoop = false;

	public static void setTileIDArray(int[][] tileIDArray) {

		ExplosionHandler.tileIDArray = tileIDArray;

	}





	public static void explode(int bombPosX, int bombPosY, int radius) {

		System.err.println("Called");

		int bombPosAsTilePosX, bombPosAsTilePosY = 0;


		bombPosAsTilePosX = bombPosX / 64;
		bombPosAsTilePosY = bombPosY / 64;
		endLoop = false;
		//Check if explosion should be vertical			
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosX - i < 30) {
				if(tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] == 3) {

					tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] = 0;
					break;

				}
				if(tileIDArray[bombPosAsTilePosX + i][bombPosAsTilePosY] == 2) {


					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {	
			if(bombPosAsTilePosX - i > 0) {
				if(tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] == 3) {

					tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX - i][bombPosAsTilePosY] == 2) {


					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosY - i < 30) {
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + i] == 3) {

					tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + i] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + 1] == 2) {


					break;
				}
			}
		}
		endLoop = false;
		for(int i = 0; i <= radius; i++) {
			if(bombPosAsTilePosY - i >= 0) {
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - i] == 3) {

					tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - i] = 0;
					break;
				}
				if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - 1] == 2) {


					break;
				}

			}
		}


	}

	public static int[][] getTileIDArray(){

		return tileIDArray;

	}



}
