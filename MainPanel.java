import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPanel extends JPanel {
	PlayerShip playShip;
	BufferedImage myPicture;
	
	public MainPanel(App frame) {
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\obx31\\OneDrive\\Desktop\\Quinnipiac Stuff\\SER-120 (Object)\\Homework\\Final\\Character.png"));
		} catch(IOException e) {
			System.out.println("fml");
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		playShip = new PlayerShip(0, 0, Color.red);
		this.add(picLabel);
	}
}
