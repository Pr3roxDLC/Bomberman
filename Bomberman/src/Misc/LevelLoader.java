package Misc;



public class LevelLoader {
	
	public static int[] levelData = new int[4];

	public static int[] boxSpawnrate = {3, 2, 4, 5, 2, 6, 10, 10};
	public static int[] enemies =  {8, 8, 12, 12, 14, 14, 16, 16};
	public static int[] radius = {1, 1, 2, 2, 3, 3, 4, 4};
	public static int[] maxBombs = {1, 2, 3, 4, 5, 6, 7, 8};
	
	
	public static int[] getLevelData(int levelCount) {
		
		levelData[0] = boxSpawnrate[levelCount];
		levelData[1] = enemies[levelCount];
		levelData[2] = radius[levelCount];
		levelData[3] = maxBombs[levelCount];
		
		return levelData;
		
	}
	
	

	
  
	
	
	public LevelLoader() {
		// TODO Auto-generated constructor stub
	}

}
