package render;

import java.awt.image.BufferedImage;
import java.util.PrimitiveIterator.OfDouble;

public class ExplosionFX {
	
	public static BufferedImage[] explosionFXTiles = new BufferedImage[32];
	static int[][] FXTileArray = new int[30][16];
	
	//Returns an Array of TileIDs corresponding to the Tiles Needed for the Explosion FX
	public static int[][] addExplosion(int offsetX, int offsetY, int radius) {
		
		System.out.println(offsetX);
		System.out.println(offsetY);
		
		int arraySize = radius * 2;
		arraySize = arraySize + 1;
		
		
		
		
		
	
		
		for(int i = radius * -1; i < radius; i++) {
			
			FXTileArray[offsetX][offsetY + i] = 1;
	
			
		}
	for(int i = radius * -1; i < radius; i++) {
			
			FXTileArray[offsetX + i][offsetY] = 2;
	
			
		}
		
		
		FXTileArray[offsetX][offsetY] = 0;
		FXTileArray[offsetX - radius][offsetY] = 5;
		FXTileArray[offsetX + radius][offsetY] = 6;
		FXTileArray[offsetX][offsetY + radius] = 4;
		FXTileArray[offsetX][offsetY - radius] = 3;
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 30; j++) {
				
				
				System.out.print(FXTileArray[j][i]);
				
			}
		System.out.println();
			
		}
		
		return FXTileArray;
		
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
