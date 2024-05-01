import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame {
	MainPanel mainPan;
	public App() {
		super("Your mother");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    mainPan = new MainPanel(this);
	    this.add(mainPan);
	    this.pack();
	    this.setVisible(true);
	 }
	public static void main(String[] args) {
		App app = new App();
	}
}
