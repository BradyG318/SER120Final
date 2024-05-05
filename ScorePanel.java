import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    JLabel score;
    public ScorePanel(App frame) {
        score = new JLabel("");
        this.add(score);

        this.setSize(100, 40);
    }
    public void setScore(int newScore) {
        score.setText("" + newScore);
        this.revalidate();
        this.repaint();
    }
    public void setScore(String str) {
        score.setText(str);
        this.revalidate();
        this.repaint();
    }
    
}