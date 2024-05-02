import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame {
	MainPanel mainPan;
	ButtonPanel butPan;
	public App() {
		super("Your mother");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    mainPan = new MainPanel(this);
		butPan = new ButtonPanel(this);
	    this.add(mainPan, BorderLayout.NORTH);
		this.add(butPan, BorderLayout.SOUTH);
	    this.pack();
	    this.setVisible(true);
	 }
	public static void main(String[] args) {
		App app = new App();
	}
	public static void playerMove(int direction) { //Uses an integer to determine player direction (0 = up, 1 = right, 2 = down, 3 = left)
		switch(direction) {
			case 0:
			break;
			case 1:
			break;
			case 2:
			break;
			case 3:
			break;
			default:
			System.out.println("DEBUG-ERROR, Invalid Direction");
			break;
		}
	}
}
