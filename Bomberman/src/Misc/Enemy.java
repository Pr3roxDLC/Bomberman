package Misc;

public class Enemy {

	int enemyPosX = 0;
	int enemyPosY = 0;
	int direction = 0;
	
	public int chooseDirection () {
		return (int)Math.random()*4+1;
	}
	
}
