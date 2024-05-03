import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JFrame{
	private int score = 666;
	private JLabel scoreLabel;
	
	public ScorePanel() {
		setTitle("Score Panel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		scoreLabel = new JLabel("Score: " + score, JLabel.CENTER);
        panel.add(scoreLabel);
		
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);	
	}
	
}
