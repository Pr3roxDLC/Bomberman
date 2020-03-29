package render;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader {

	public static BufferedImage ladeBild(String path) {
		try {
			return ImageIO.read(ResourceLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			
			System.exit(1);
		}
		return null;
	}

}
