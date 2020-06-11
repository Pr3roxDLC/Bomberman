package game;

import render.TileRenderer;

public class LevelEnd {

	public static int xPos = 0;
	public static int yPos = 0;
	public static int playerPosX = 0;
	public static int playerPosY = 0;
	public static int livingEnemies = 1;
	public static boolean hasLevelEnded = false;
	public static boolean playerIsTouchingEndTile = false;
	public static int[][] tileIDArray = new int[30][16];
	public static int textSize = 75;
	public static int framesSinceLastTextSizeUpdate = 0;
	public static float opacity = 0;
	public static int currentLevelEndTileX = 0;
	public static int currentLevelEndTileY = 0;



	public static void checkForLevelEnd() {





		if(livingEnemies <= 0 && hasLevelEnded == false) {
			genLevelEndTile();

		}


	}

	public static int[][] getTileIdArray(){

		return tileIDArray;

	}

	public static void setTileIDArrayForLevelEnd(int[][] tileIDArray2) {

		tileIDArray = tileIDArray2;

	}

	public static void setPlayerPosForLevelEnd(int posX, int posY) {

		playerPosX = posX;
		playerPosY = posY;

	}


	public static void checkForPlayerColWithEndTile() {

		//		System.out.println(playerPosX+ " "+ playerPosY);

		if(Misc.Utils.RoundNumberToMultipleOf64(playerPosX) == xPos * 64 && Misc.Utils.RoundNumberToMultipleOf64(playerPosY) == yPos * 64) {
			if(playerIsTouchingEndTile == false) {
				System.out.println("[LevelEnd]: Player has Touched the Level End Tile!");
			}
			playerIsTouchingEndTile = true;

			hasLevelEnded = true;


		}

	}

	public static void resetLevelEnd() {

		hasLevelEnded = false;
		playerIsTouchingEndTile = false;
		tileIDArray[currentLevelEndTileX][currentLevelEndTileY] = 0;		
	}

	public static boolean getPlayerIsTouchingEndTile() {

		return playerIsTouchingEndTile;

	}

	public static int getTextSize() {

		return textSize;

	}

	public static void updateTextSize() {
		framesSinceLastTextSizeUpdate ++;
		if(framesSinceLastTextSizeUpdate >= 2) {

			textSize= textSize + 4;
			framesSinceLastTextSizeUpdate = 0;
		}

	}

	public static float getUpdatedOpacity() {

		if(opacity < 1) {
			opacity = opacity + 0.0078125F;

		}

		return opacity;
	}


	public static void genLevelEndTile() {

		System.out.println("[LevelEnd]: Generating Level End Tile!");



		int randx = Misc.Utils.random(25, 2);
		int randy = Misc.Utils.random(15, 3);

		while(true) {

			randx = Misc.Utils.random(25, 2);
			randy = Misc.Utils.random(15, 3);

			if(tileIDArray[randx][randy] == 0) {
				xPos = randx;
				yPos = randy;
				currentLevelEndTileX = randx;
				currentLevelEndTileY = randy;

				tileIDArray[randx][randy] = 5;

				hasLevelEnded = true;
				return;

			}
		}

	}

}
