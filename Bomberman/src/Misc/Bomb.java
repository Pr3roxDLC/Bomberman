package Misc;

import game.ExplosionHandler;

public class Bomb {

	public boolean used = true;
	int x, y = 0;
	int timer = 0;

	public void incBombTimer() {

		if(timer < 48) {

			timer++;

		}else {
			ExplosionHandler.explode(x, y);
			
			used = false;
			
		}


		

	}

	public boolean getUsed() {

		return used;

	}

	public void setUsed(boolean used) {

		this.used = used;

	}

	
	public int getBombPosX() {
		return x;
		
	}
	
	public int getBombPosY() {
		return y;
		
	}
	
	
	

	public Bomb(int x, int y) {

		this.x = x;
		this.y = y;


	}



}
