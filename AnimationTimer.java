import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class AnimationTimer extends Timer {
    private MainPanel mp;

    public AnimationTimer(MainPanel mp) {
        super(50, null);
        this.mp = mp;
        this.addActionListener(new MoveListener());
    }
    private class MoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mp.eBounce();
        }
    }
}

