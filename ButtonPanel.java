import java.awt.Button;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

    JButton buttons[];
    int numButtons;
    public ButtonPanel(App frame) {
        numButtons = 0;

        Dimension d = new Dimension(100, 20);
        this.setSize(d);
        this.setPreferredSize(d);
    }
    public void add(JButton button) { 
        numButtons++;
        this.add(button); 
    }
}
