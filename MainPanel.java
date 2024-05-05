import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainPanel extends JPanel  {
	PlayerShip playShip;
	BufferedImage playerPic, enemyPic;
	JLabel player, enemy; 
	JLabel[] enemies; 
	JLabel score; 
	int scoreVal;

	int eCount; 

	int[][] enemyLoc;
	//ButtonGroup btnGrp;
	//JButton up, down, left, right;
	//ButtonPanel butPan; 

	Dimension d, picSize;
	int width, height;
	private AnimationTimer timer;

	Image scaledEnemyPic;

	ScorePanel scorePan;

	//Movement thingy
	// int dx = 1;
	// int dy = 3;

	public MainPanel(App frame, ScorePanel scorePan) {
		this.scorePan = scorePan;
		eCount = 0;
		scoreVal = 0;
		// score = new JLabel("" + scoreVal);
		// score.setSize(400, 50);
		//Panel setup
		//super(new BorderLayout());
		this.setLayout(null);
		width = 500;
		height = 500; 
		d = new Dimension(width, height);
		//butPan = new ButtonPanel(frame);
		this.setSize(d);
		this.setPreferredSize(d); 

		//Button Intialization
		// btnGrp = new ButtonGroup();
		// up = new JButton("Up");
		// btnGrp.add(up);
		// down = new JButton("Down");
		// btnGrp.add(down);
		// left = new JButton("Left");
		// btnGrp.add(left);
		// right = new JButton("Right");
		// btnGrp.add(right); 
		
		//Player spawner
		try {
			playerPic = ImageIO.read(new File("Character.png"));
			enemyPic = ImageIO.read(new File("Enemy.png"));
		} catch(IOException e) {
			System.out.println("DEBUG-fml");
		}
		player = new JLabel(new ImageIcon(playerPic));
		enemy = new JLabel(new ImageIcon(enemyPic));	
		picSize = new Dimension(15, 15);
		scaledEnemyPic = enemyPic.getScaledInstance(picSize.width, picSize.height, Image.SCALE_SMOOTH);

		player.setSize(picSize); 
		player.setPreferredSize((picSize));
		
		enemy.setSize(picSize);		
		enemy.setPreferredSize(picSize);
		this.add(player);
		//this.add(enemy);
		player.setLocation(480, 250);
		//enemy.setLocation(0, 0);

		//Button Dump
		// up.addActionListener(this);
		// down.addActionListener(this);
		// right.addActionListener(this);
		// left.addActionListener(this);

		// butPan.add(up);
		// butPan.add(down);
		// butPan.add(right);
		// butPan.add(left);
		System.out.println("DEBUG-Buttons");
		//this.add(butPan, BorderLayout.SOUTH);
		

		timer = new AnimationTimer(this);
	}

	public void eBounce() { //Meant to make the enemies fall slowly and bounce of the sides
		//System.out.println("DEBUG-\nWidth/X: " + d.getWidth() + "/" + enemy.getX() + "\nHeight/Y" + d.getHeight() + "/" + enemy.getY());
		int dx = 3;
		int dy = 1;
		for(int i = 0; i<enemies.length; i++) {
			if(enemies[i].getX() > d.getWidth()) { // If on the right wall
				enemyLoc[0][i] = -dx;
				enemyLoc[1][i] = (int)(3*Math.random());
			} if(enemies[i].getY() > d.getHeight()) { //If on ground
				enemies[i].hide();
				scoreVal++;
				enemyLoc[0][i] = 0;
				enemyLoc[1][i] = 0;
				enemies[i].setLocation(5, 5);
				// enemyLoc[1][i] = -dy;
				// enemyLoc[0][i] = (int)(3*Math.random());
			} if(enemies[i].getX() < 0) { //If on left wall 
				enemyLoc[0][i] = 1;
				enemyLoc[1][i] = (int)(3*Math.random());
			} if(enemies[i].getY() < 0) { //If on roof
				enemyLoc[1][i] = 3;
				enemyLoc[0][i] = (int)(3*Math.random());
			}
			scorePan.setScore("" + scoreVal);
			enemies[i].setLocation(enemies[i].getX()+enemyLoc[0][i], enemies[i].getY()+enemyLoc[1][i]);
			if(enemies[i].getBounds().equals(player.getBounds())) {
				scorePan.setScore("You died, you lose");
				timer.stop();
				break;
			}
		}
		this.revalidate();
		this.repaint(); 
		if(eCount == scoreVal) {
			timer.stop();
			scorePan.setScore("Congrats, you won the game!"); 
		}
		
	}
	public void characterMover(int dx, int dy) {
		player.setLocation(player.getX()+dx, player.getY()+dy);
	}
	public void enemySpawner(int eCount) {
		this.eCount = eCount;
		enemies = new JLabel[eCount];
		enemyLoc = new int[2][eCount]; //Saves CHANGE x/y in a 2d Array
		int tempY = 0;
		for(int i = 0; i<enemies.length; i++) {
			enemies[i] = new JLabel(new ImageIcon(scaledEnemyPic));
			enemyLoc[0][i] = 3;
			enemyLoc[1][i] = -1;
			enemies[i].setLocation(0, tempY);
			enemies[i].setSize(picSize);
			this.add(enemies[i]);
			tempY += 500/eCount;
			System.out.println("DEBUG-" + tempY);
		}
	}
	public void gameStart() {
		timer.start();
	}
	public void gamePause() {
		timer.stop();
	}
	public void setAvatar(int choice) {
		switch(choice) {
			case 0:
			try {
				playerPic = ImageIO.read(new File("Character.png"));
			} catch(IOException e) {
				System.out.println("Read Error");
			}
			break;
			case 1:
			try {
				playerPic = ImageIO.read(new File("Character2.png"));
			} catch(IOException e) {
				System.out.println("Read Error");
			}
			break;
			case 2:
			try {
				playerPic = ImageIO.read(new File("Character3.png"));
			} catch(IOException e) {
				System.out.println("Read Error");
			}
			break;
		}
		this.revalidate();
		this.repaint();
	}

	
}

