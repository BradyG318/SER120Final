import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyButtons extends JFrame{
	public DifficultyButtons() {
		setTitle("Chose your Diffculty");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		
		JButton easyButton = new JButton("Easiey Peasie");
        JButton mediumButton = new JButton("Eh Not to Hard and Not to Easy");
        JButton hardButton = new JButton("Horrible");
		
		//Action Listener shit here 
        
        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
        
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);	
	}
}
