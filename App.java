import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App extends JFrame {
	private static MainPanel mainPan;
	private ButtonPanel butPan;
	private ScorePanel scorePan;
	public App() {
		super("SER-120 Final");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		scorePan = new ScorePanel(this);
		mainPan = new MainPanel(this, scorePan);
		butPan = new ButtonPanel(this, mainPan);
		this.add(scorePan, BorderLayout.NORTH);
	    this.add(mainPan, BorderLayout.CENTER);
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
