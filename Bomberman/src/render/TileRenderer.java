package render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileRenderer {
	
	//Array to store the ID of each Tile in
	public BufferedImage[] tileSet = new BufferedImage[64];
	//Array that gets pushed to the GUI containing information about what TileID needs to be drawn at what position.
	public int[][] tileIDArray = new int[30][16];
	
	public static void main() {
		
		
		
	}
	
	
	
	
	public void initTiles() {
		
		// Load devTile1 into Memory
		BufferedImage devTile1 = null;
		try {
		    devTile1 = ImageIO.read(new File("C:\\Users\\Tim\\Desktop\\Dev.png"));
		} catch (IOException e) {
		}
		tileSet[0] = devTile1;
		
		//Load devTile2 into Memory
		BufferedImage devTile2 = null;
		try {
		    devTile2 = ImageIO.read(new File("C:\\Users\\Tim\\Desktop\\Dev2.png"));
		} catch (IOException e) {
		}
		tileSet[1] = devTile2;
		
		//Fill the tileIDArray with devTile1
		for(int i = 0; i < tileIDArray.length; i++) {
			for(int j = 0; j < tileIDArray[i].length; j++ ) {
				
				tileIDArray[i][j] = 0;
			
				
			}
			
			
		}
		

		
	}
	//Returns the Tile assigned to the given TileID
public BufferedImage getTile(int i) {
	
	return tileSet[i];
}	

	//Assign a position a new TileID
public void addTile(int tileID, int y, int x) {
	
	tileIDArray[y][x] = tileID;
	
	
}








}
