import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends BufferedImage {
	public Player(int width, int height, int imageType) {
		super(width, height, imageType);
		try {                
	          super = ImageIO.read(new File(path));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}
}
