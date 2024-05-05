import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JPanel implements ActionListener {
    JButton up, down, left, right, start, pause;
    JRadioButton easy, medium, hard, impossible;
    int numButtons;
    App frame;
    MainPanel main;
    public ButtonPanel(App frame, MainPanel main) {
        setLayout(new GridLayout(3,4));
        this.main = main;
        this.frame = frame; 
        up = new JButton("Up");
        down = new JButton("Down"); 
        left = new JButton("Left");
        right = new JButton("Right");

        up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);

        this.add(up);
        this.add(down);
        this.add(left);
        this.add(right);


        easy = new JRadioButton("Easy");
        medium = new JRadioButton("Medium");
        hard = new JRadioButton("Hard");
        impossible = new JRadioButton("Impossible");

        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);
        impossible.addActionListener(this);

        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(impossible);


        start = new JButton("Start");
        pause = new JButton("Pause");

        start.addActionListener(this);
        pause.addActionListener(this);

        this.add(start);
        this.add(pause);


        Dimension d = new Dimension(100,40);
        this.setSize(d);
        this.setPreferredSize(d);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int moveAmt = 5; //Makes it easier to adjust everything at once
        // TODO Auto-generated method stub
        System.out.println("DEBUG-" + e.getActionCommand());
        switch(e.getActionCommand()){
        case("Up"): //Movement Controls
        System.out.println("DEBUG-Upp");
        frame.playerMove(0, -moveAmt);
        break;
        case("Down"):
        System.out.println("DEBUG-Downn");
        frame.playerMove(0, moveAmt);
        break;
        case("Right"):
        System.out.println("DEBUG-Rightt");
        frame.playerMove(moveAmt, 0);
        break;
        case("Left"):
        System.out.println("DEBUG-Leftt");
        frame.playerMove(-moveAmt, 0);
        break;
        case("Easy"): //Difficulty COntrols
        main.enemySpawner(5);
        break;
        case("Medium"):
        main.enemySpawner(15);
        break;
        case("Hard"):
        main.enemySpawner(30);
        break;
        case("Impossible"):
        main.enemySpawner(50);
        break;
        case("Start"): //Start/Pause
        main.gameStart();
        break;
        case("Pause"):
        main.gamePause();
        break;
        }
        main.revalidate();
        main.repaint();
    }
}
