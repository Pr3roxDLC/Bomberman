package game;

public class ExplosionHandler {
	
	public static int[][] tileIDArray = new int[30][16];
	
	public static void setTileIDArray(int[][] tileIDArray) {
		
		ExplosionHandler.tileIDArray = tileIDArray;
		
	}
	
	
	
	
	
	public static void explode(int bombPosX, int bombPosY) {
		
		
		int bombPosAsTilePosX, bombPosAsTilePosY = 0;
	
		
		bombPosAsTilePosX = bombPosX / 64;
		bombPosAsTilePosY = bombPosY / 64;
		//Check if explosion should be vertical			
		
		if(tileIDArray[bombPosAsTilePosX + 1][bombPosAsTilePosY] == 3) {
			
			tileIDArray[bombPosAsTilePosX + 1][bombPosAsTilePosY] = 0;
			
		}
if(tileIDArray[bombPosAsTilePosX - 1][bombPosAsTilePosY] == 3) {
			
			tileIDArray[bombPosAsTilePosX - 1][bombPosAsTilePosY] = 0;
			
		}
if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + 1] == 3) {
	
	tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY + 1] = 0;
	
}
if(tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - 1] == 3) {
	
	tileIDArray[bombPosAsTilePosX][bombPosAsTilePosY - 1] = 0;
	
}
		
		
	}
	
	public static int[][] getTileIDArray(){
		
		return tileIDArray;
		
	}
	
	

}
