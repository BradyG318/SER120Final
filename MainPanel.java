import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainPanel extends JPanel implements ActionListener {
	PlayerShip playShip;
	BufferedImage playerPic, enemyPic;
	JLabel player, enemy; 
	ButtonGroup btnGrp;
	JButton up, down, left, right;
	Dimension d, picSize;
	int width, height;
	BufferedImage[] enemies;  //In for testing reasons, I should move this into a dedicated class soon
	private AnimationTimer timer;

	//Movement thingy
	int dx = 1;
	int dy = 3;

	public MainPanel(App frame) {
		//Panel setup
		width = 500;
		height = 500; 
		d = new Dimension(width, height);
		this.setSize(d);
		this.setPreferredSize(d); 

		//Button Intialization
		btnGrp = new ButtonGroup();
		up = new JButton("Up");
		btnGrp.add(up);
		down = new JButton("Down");
		btnGrp.add(down);
		left = new JButton("Left");
		btnGrp.add(left);
		right = new JButton("Right");
		btnGrp.add(right); 
		
		//Player spawner
		try {
			playerPic = ImageIO.read(new File("C:\\Users\\obx31\\OneDrive\\Desktop\\Quinnipiac Stuff\\SER-120 (Object)\\Homework\\Final\\Character.png"));
			enemyPic = ImageIO.read(new File("C:\\Users\\obx31\\OneDrive\\Desktop\\Quinnipiac Stuff\\SER-120 (Object)\\Homework\\Final\\Enemy.png"));
		} catch(IOException e) {
			System.out.println("DEBUG-fml");
		}
		player = new JLabel(new ImageIcon(playerPic));
		enemy = new JLabel(new ImageIcon(enemyPic));
		picSize = new Dimension(30, 30);
		player.setSize(picSize); 
		player.setPreferredSize((picSize));
		enemy.setSize(picSize);		
		enemy.setPreferredSize(picSize);
		this.add(player);
		this.add(enemy);

		//Button Dump
		up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
		this.add(up, BorderLayout.NORTH);
		this.add(down, BorderLayout.NORTH);
		this.add(right, BorderLayout.NORTH);
		this.add(left, BorderLayout.NORTH);

		timer = new AnimationTimer(this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("DEBUG-Action Performed: " + e.getActionCommand());
	}
	public void eBounce() { //Meant to make the enemies fall slowly and bounce of the sides
		System.out.println("DEBUG-Width/X: " + d.getWidth() + "/" + enemy.getX() + "\nHeight/Y" + d.getHeight() + "/" + enemy.getY());
		if(enemy.getX() > d.getWidth()) { // If on the right wall
			dx = -1;
		} if(enemy.getY() > d.getHeight()) { //If on ground
			dy = -3;
		} if(enemy.getX() < 0) { //If on left wall 
			dx = 1;
		} if(enemy.getY() < 0) { //if on roof
			dy = 3;
		}
		enemy.setLocation(enemy.getX()+dx, enemy.getY()+dy);
	}
}
