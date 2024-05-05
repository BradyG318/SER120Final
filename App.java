import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame {
	static MainPanel mainPan;
	ButtonPanel butPan;
	public App() {
		super("Your mother");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    mainPan = new MainPanel(this);
		butPan = new ButtonPanel(this, mainPan);
	    this.add(mainPan, BorderLayout.NORTH);
		this.add(butPan, BorderLayout.SOUTH);
	    this.pack();
	    this.setVisible(true);
	 }
	public static void main(String[] args) {
		App app = new App();
	}
	public static void playerMove(int dx, int dy) { //Passes the movement on to the mainPanel for the character
		mainPan.characterMover(dx, dy);
	}
}
