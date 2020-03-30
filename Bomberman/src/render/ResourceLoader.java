package render;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader {

	
	//100% Not Moritz's Resource Loader
	
	public static BufferedImage ladeBild(String path) {
		try {
			System.out.println("[ResourceLoader]: Moritz Resource Loader has Worked!");
			return ImageIO.read(ResourceLoader.class.getResource(path));
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
			System.exit(1);
		}
		return null;
		
	}

}
