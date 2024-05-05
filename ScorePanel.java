//Brady Galligan + Aislin Hayes 
//Professor Gulum 
//May 4, 2024
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    private JLabel score;
    private App frame;
    public ScorePanel(App frame) {
        this.frame = frame;
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
