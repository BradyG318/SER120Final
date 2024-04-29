import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	PlayerShip playShip;
	public MainPanel(App frame) {
		playShip = new PlayerShip(0, 0, Color.red);
		this.add(playShip);
	}
}
