import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
    JButton up, down, left, right;
    int numButtons;
    App frame;
    public ButtonPanel(App frame) {
        setLayout(new GridLayout(1,4));
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


        Dimension d = new Dimension(100, 20);
        this.setSize(d);
        this.setPreferredSize(d);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch(e.getActionCommand()){
        case("Up"):
        System.out.println("DEBUG-Upp");
        break;
        case("Down"):
        System.out.println("DEBUG-Downn");
        break;
        case("Right"):
        System.out.println("DEBUG-Rightt");
        break;
        case("Left"):
        System.out.println("DEBUG-Leftt");
        break;
        }
    }
}
