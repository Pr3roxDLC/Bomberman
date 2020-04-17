package game;

import java.awt.image.BufferedImage;

import render.ResourceLoader;

public class EnemyMover {
	int enemyPosX = 0;
	int enemyPosY = 0;
	int[][] tileIDArray = new int [30][16];
	int distance = 0;
	int direction = 0;
	BufferedImage enemyTile = null;
	
	
	public void initEnemy() {
		enemyTile = ResourceLoader.ladeBild("/Dev.png");
	}
	
	public BufferedImage getEnemyTile() {
		return enemyTile;
	}
	
	public int chooseDirection () {
		return (int)Math.random()*4+1;
	}

	public void setTileIDArray(int[][] tileIDArray) {
		this.tileIDArray = tileIDArray;
	}

	public void distanceCalc() {
		direction = chooseDirection();
		switch (direction) {

		case 1:	
			int i = 1; 
			while ((tileIDArray[(enemyPosX/64)][(enemyPosY/64)-i] == 0 )){ 
				i++;
			}
			distance = i;
			break;

		case 2:
			int j = 1; 
			while ((tileIDArray[(enemyPosX/64)+j][(enemyPosY/64)] == 0 )){ 
				j++;
			}
			distance = j;
			break;

		case 3: 
			int k = 1; 
			while ((tileIDArray[(enemyPosX/64)][(enemyPosY/64)+k] == 0 )){ 
				k++;
			}
			distance = k;
			break;

		case 4:
			int l = 1; 
			while ((tileIDArray[(enemyPosX/64)-l][(enemyPosY/64)] == 0 )){ 
				l++;
			}
			distance = l;
			break;
		}
	}

	public void moveEnemy() {

		switch (direction) {

		case 1:
			for(int i = 0; i < distance*16; i++) {
				enemyPosX = enemyPosX-4;
			}
			break;

		case 2:
			for(int i = 0; i < distance*16; i++) {
				enemyPosY = enemyPosY+4;
			}
			break;

		case 3:
			for(int i = 0; i < distance*16; i++) {
				enemyPosX = enemyPosX+4;
			}
			break;

		case 4:
			for(int i = 0; i < distance*16; i++) {
				enemyPosY = enemyPosY-4;
			}
			break;
		}
	}







}