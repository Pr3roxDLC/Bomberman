package render;

import java.awt.image.BufferedImage;

public class AnimatedTileRenderer {

	public int frame = 0;
	BufferedImage[][] animationArray = new BufferedImage[64][64];
	
	
	public void initATR() {
		System.out.println("[Animated Tile Renderer]: Started Init Sequence");
		
		for(int i = 0; i < 64; i++) {
			for(int j = 0; j < 64; j++) {
				
				animationArray[i][j] = null;
				
			}
			
		}
		
		//Load all animated tiles and put each set of Tiles in one Array for easier use later
		//Each Frame is Displayed for 2 Frames
		animationArray[0][0] = ResourceLoader.ladeBild("/anim/TestAnim1.png");
		animationArray[0][1] = ResourceLoader.ladeBild("/anim/TestAnim2.png");
		animationArray[0][2] = ResourceLoader.ladeBild("/anim/TestAnim3.png");
		animationArray[0][3] = ResourceLoader.ladeBild("/anim/TestAnim4.png");
		System.out.println("[Animated Tile Renderer]: Completed Init Sequence");
	}
	
	public void incGameFrame() {
		frame++;
	}
	
	
	
	
	public BufferedImage getCurrentFrame(int frame, int animationTileID) {
		
		
		
		return animationArray[animationTileID][frame];
	}
	
	
}
