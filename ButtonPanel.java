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
    JRadioButton p1, p2, a1, a2, a3, a4; 
    JButton quit;
    int numButtons;
    App frame;
    
    MainPanel main;
    public ButtonPanel(App frame, MainPanel main) {
        setLayout(new GridLayout(5,4));
        this.main = main;
        this.frame = frame; 
        up = new JButton("Up");
        down = new JButton("Down"); 
        left = new JButton("Left");
        right = new JButton("Right");
        quit = new JButton("Quit");

        up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
        quit.addActionListener(this);

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

        a1 = new JRadioButton("Avatar1");
        a2 = new JRadioButton("Avatar2");
        a3 = new JRadioButton("Avatar3");
        a4 = new JRadioButton("Avatar4"); 
        p1 = new JRadioButton("");
        p2 = new JRadioButton("");

        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);

        this.add(p1); //I know it's a janky fix, but these are here as placeholders to fill in the gaps
        this.add(p2);

        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(a4);
        this.add(quit);

        Dimension d = new Dimension(100,80);
        this.setSize(d);
        this.setPreferredSize(d);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int moveAmt = 10; //Makes it easier to adjust everything at once
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
        case("Avatar1"):
        main.setAvatar(0);
        break;
        case("Avatar2"):
        main.setAvatar(1);
        break;
        case("Avatar3"):
        main.setAvatar(2);
        break;
        case("Avatar4"):
        main.setAvatar(3);
        break;
        case("Quit"):
        frame.dispose();
        break;
        }
        main.revalidate();
        main.repaint();
    }
}
