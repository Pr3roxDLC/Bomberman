package render;

import java.awt.image.BufferedImage;



public class AnimatedPlayerRenderer {

	BufferedImage []playerTilesFacingSouth = new BufferedImage[12];
	BufferedImage []playerTilesFacingNorth = new BufferedImage[12];
	BufferedImage []playerTilesFacingEast = new BufferedImage[12];
	BufferedImage []playerTilesFacingWest = new BufferedImage[12];
	int frame = 0;
	int lastdir = 3;

	public void updatePlayer(){
		
		if(frame < 11)
		{
			
			frame++;
		}else {
			
			frame = 0;
			
		}
		
		
	}

	public AnimatedPlayerRenderer(java.lang.String[] playerFacingSouthTile, java.lang.String[] playerFacingNorthTile, java.lang.String[] playerFacingEastTile, java.lang.String[] playerFacingWestTile, int framelenght) {

	
		
		for(int i = 0; i < playerFacingSouthTile.length; i++) {

			for (int k = 0; k < framelenght; k++) {
				System.out.println("[Animated Tile Renderer]: Wrote a Tile to Location: " + ((i*framelenght)+k));
				playerTilesFacingSouth[((i * framelenght) + k)]  = ResourceLoader.ladeBild(playerFacingSouthTile[i]);
			}
		}
		
		for(int i = 0; i < playerFacingNorthTile.length; i++) {

			for (int k = 0; k < framelenght; k++) {
				System.out.println("[Animated Tile Renderer]: Wrote a Tile to Location: " + ((i*framelenght)+k));
				playerTilesFacingNorth[((i * framelenght) + k)]  = ResourceLoader.ladeBild(playerFacingNorthTile[i]);
			}
		}
		
		for(int i = 0; i < playerFacingWestTile.length; i++) {

			for (int k = 0; k < framelenght; k++) {
				System.out.println("[Animated Tile Renderer]: Wrote a Tile to Location: " + ((i*framelenght)+k));
				playerTilesFacingWest[((i * framelenght) + k)]  = ResourceLoader.ladeBild(playerFacingWestTile[i]);
			}
		}
		
		for(int i = 0; i < playerFacingEastTile.length; i++) {

			for (int k = 0; k < framelenght; k++) {
				System.out.println("[Animated Tile Renderer]: Wrote a Tile to Location: " + ((i*framelenght)+k));
				playerTilesFacingEast[((i * framelenght) + k)]  = ResourceLoader.ladeBild(playerFacingEastTile[i]);
			}
		}



	}

	public BufferedImage getPlayerTile(int dir) {

		

		switch(dir) {

		case 1:
			lastdir = 1;
			return playerTilesFacingNorth[frame];
		case 2:
			lastdir = 2;
			return playerTilesFacingWest[frame];
		case 3:
			lastdir = 3;
			return playerTilesFacingSouth[frame];
		case 4:
			lastdir = 4;
			return playerTilesFacingEast[frame];
		default:
		switch (lastdir) {
		case 1:
			return playerTilesFacingNorth[frame];
		case 2:
			return playerTilesFacingWest[frame];
		case 3:
			return playerTilesFacingSouth[frame];
		case 4:
			return playerTilesFacingEast[frame];
			
		}
		return null;
		
		}



	}






}
