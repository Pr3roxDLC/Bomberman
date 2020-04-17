package game;


//LEO

public class MapManager {
	//30 auf 12

	public int[][] tileIDArray = new int[30][16]; 

	public int[][] getTileIDArray() {
		return tileIDArray;
	}
	
	public void genCrates(int chance) {
		
		for(int i = 0; i < 30; i++) {
			for(int k = 0; k < 16; k++) {
				
				if(tileIDArray[i][k] == 0) {
					
					int random = (int) (Math.random() * 10);
					
					if (random % chance == 0) {
						
						tileIDArray[i][k] = 3;
						
					}
					
				}
				
			}
			
			
		}
		
		for(int i = 0; i < 4; i++) {
			for(int k = 0; k < 5; k++) {
				
				if(tileIDArray[i][k] == 3) {
					
					tileIDArray[i][k] = 0;
					
				}
				
			}
			
			
		}
		
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
	}
}
