package game;

public class MapManager {
	//30 auf 12

	public int[][] tileIDArray = new int[30][16]; 

	public int[][] getTileIDArray() {
		return tileIDArray;
	}

	public void initWalls() {
		for (int i = 0; i<30; i++) {
			tileIDArray[i][1] = 2;
			tileIDArray[i][15] = 2;
		}

		for (int i = 0; i<15; i++) {
			tileIDArray[0][i] = 2;
			tileIDArray[26][i] = 2;
		}

		for (int i = 0; i<30; i++) {
			for(int k = 0; k < 15; k++) {
				if(i % 2 == 0 && k % 2 != 0) {
					tileIDArray[i][k] = 2;
				}
			}
		}
		tileIDArray[2][5] = 0;
	}
}
