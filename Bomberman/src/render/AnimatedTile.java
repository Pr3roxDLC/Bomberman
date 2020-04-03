package render;


import java.awt.image.BufferedImage;


public class AnimatedTile {

	//INFO: Total Animation Frames x Frames Each Frame is displayed can not be higher than 128


	public int frame = 0;
	BufferedImage[] animationArray = new BufferedImage[128];
	public int animationDuration = 0;




	public void updateAnimation() {

		if(frame < animationDuration) {

			frame++;

		}else {


			frame = 0;

		}

	}

	public BufferedImage getCurrentFrame() {
		return animationArray[frame];
	}











	public AnimatedTile(String[] TileNames, int FrameDisplayDuration) {

		animationDuration = TileNames.length * FrameDisplayDuration;


		for(int i = 0; i < animationDuration; i++) {
			animationArray[i] = null;
		}


		
		for(int i = 0; i < TileNames.length; i++) {

			for (int k = 0; k < FrameDisplayDuration; k++) {
				System.out.println("[Animated Tile Renderer]: Wrote a Tile to Location: " + ((i*FrameDisplayDuration)+k));
				animationArray[((i * FrameDisplayDuration) + k)]  = ResourceLoader.ladeBild("/anim/" + TileNames[i]);
			}

			

		}

	}

}
