package render;

import java.awt.image.BufferedImage;


public class ExplosionFX {

	public static BufferedImage[] explosionFXTiles = new BufferedImage[32];
	static int[][] FXTileArray = new int[30][16];
	public static int[][] timeSinceTileHasBeenCreated = new int[30][16];
	

	//Returns an Array of TileIDs corresponding to the Tiles Needed for the Explosion FX
	public static int[][] addExplosion(int offsetX, int offsetY, int lengthDown, int lengthUp, int lengthLeft, int lengthRight) {







		//Determines at what cords what parts of the explosions should be shown.
		for(int i = 0; i < lengthUp; i++) {

			FXTileArray[offsetX][offsetY + i] = 1;
			timeSinceTileHasBeenCreated[offsetX][offsetY + i] = 0;

		}

		for(int i = 0; i < lengthDown; i++) {

			FXTileArray[offsetX][offsetY - i] = 1;
			timeSinceTileHasBeenCreated[offsetX][offsetY - i] = 0;

		}

		for(int i = 0; i < lengthRight; i++) {

			FXTileArray[offsetX + i][offsetY] = 2;
			timeSinceTileHasBeenCreated[offsetX + i][offsetY] = 0;

		}

		for(int i = 0; i < lengthLeft; i++) {

			FXTileArray[offsetX - i][offsetY] = 2;
			timeSinceTileHasBeenCreated[offsetX - i][offsetY] = 0;

		}
		
		
		


		FXTileArray[offsetX - lengthLeft][offsetY] = 5;
		timeSinceTileHasBeenCreated[offsetX - lengthLeft][offsetY] = 0;
		FXTileArray[offsetX + lengthRight][offsetY] = 6;
		timeSinceTileHasBeenCreated[offsetX + lengthRight][offsetY] = 0;
		FXTileArray[offsetX][offsetY + lengthUp] = 4;
		timeSinceTileHasBeenCreated[offsetX][offsetY + lengthUp] = 0;
		FXTileArray[offsetX][offsetY - lengthDown] = 3;
		timeSinceTileHasBeenCreated[offsetX][offsetY - lengthDown] = 0;
		FXTileArray[offsetX][offsetY] = 0;
		timeSinceTileHasBeenCreated[offsetX][offsetY] = 0;


		//Uncomment this to see the Explosion FX Array printed out
		
//		for(int i = 0; i < 16; i++) {
//			for(int j = 0; j < 30; j++) {
//
//
//				System.out.print(FXTileArray[j][i]);
//
//			}
//			System.out.println();
//
//		}
		
		
	
		return FXTileArray;

	}

	public static void updateFX() {
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 30; j++) {


				if(FXTileArray[j][i] != 7) {
					
					timeSinceTileHasBeenCreated[j][i]++;
					
				}

			}
			
			
	
			
			

		}
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 30; j++) {


				if(timeSinceTileHasBeenCreated[j][i] == 32) {
					
					FXTileArray[j][i] = 7;
					timeSinceTileHasBeenCreated[j][i] = 0;
					
				}

			}
		}
		
	}

	public static int[][] getFXTileArray(){

		return FXTileArray;

	}

	public static BufferedImage getFXTile(int i) {

		return explosionFXTiles[i];

	}



	public ExplosionFX() {

		for(int i = 0; i < 30 ; i++) {
			for(int j = 0; j < 16; j++) {

				FXTileArray[i][j] = 7;



			}


		}

		explosionFXTiles[0] = ResourceLoader.ladeBild("/CenterExplosionFXTile.png");
		explosionFXTiles[1] = ResourceLoader.ladeBild("/VerticalExplosionFXTile.png");
		explosionFXTiles[2] = ResourceLoader.ladeBild("/HorizontalExplosionFXTile.png");
		explosionFXTiles[3] = ResourceLoader.ladeBild("/TopEndExplosionFXTile.png");
		explosionFXTiles[4] = ResourceLoader.ladeBild("/BottomEndExplosionFXTile.png");
		explosionFXTiles[5] = ResourceLoader.ladeBild("/LeftEndExplosionFXTile.png");
		explosionFXTiles[6] = ResourceLoader.ladeBild("/RightEndExplosionFXTile.png");
		explosionFXTiles[7] = null;
	}

}
