import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WhackAMole implements ActionListener, KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	public static final int WIDTH = 1400;
	public static final int HEIGHT = 900;
	int molesPressed = 0;
	int nonMolesPressed = 0;
	ArrayList<Cloud> cloudList = new ArrayList<Cloud>();
	Font font = new Font("Comic Sans MS", Font.BOLD, 30);
	Font fontEndScreen = new Font("Comic Sans MS", Font.BOLD, 80);
	Font fontRestartText = new Font("Comic Sans MS", Font.BOLD, 40);
	int[] cloudsX = new int[130];
	int[] cloudsY = new int[130];
	int seconds = 0;
	boolean isOnEndState = false;
	Timer timer;
	Random gen = new Random();

	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.startUp();
	}

	void startUp() {
		timer = new Timer(1000, this);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		int blue = 255;
		int red = 0;
		int green = 0;
		for (int y = 50; y < HEIGHT; y += 30) {
			Color culMKtwo = new Color(red, green, blue);
			blue -= 7;
			red += 7;
			green += 2;
			makeDaClouds(y, culMKtwo);
		}

		randomize();
		timer.start();
	}

	void randomize() {
		panel = new JPanel();
		frame.add(panel);
		Font f = new Font("Arial", 0, 9);
		for (int i = 0; i < 375; i += 1) {
			Icon image = new ImageIcon("Mole.jpg");
			JButton button = new JButton();
			button.setPreferredSize(new Dimension(50, 50));
			button.addActionListener(this);
			int num = gen.nextInt(100);
			if (num < 7) {
				button.setFont(f);
				button.setIcon(image);
				button.setText("");

			}

			else {
				button.setText(" ");
			}

			panel.add(button);

		}

		frame.pack();
		frame.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			if (isOnEndState == false) {
				seconds = seconds + 1;
				frame.setTitle("Time: " + seconds);
			}
		}

		else {
			JButton clicked = (JButton) e.getSource();
			if (clicked.getText().equals("")) {
				System.out.println("WHACK");
				molesPressed = molesPressed + 1;
				frame.remove(panel);

				randomize();
			}

			else {
				System.out.println("ERROR");
				isOnEndState = true;
				drawEndState(frame.getGraphics());
				nonMolesPressed = nonMolesPressed + 1;
				frame.remove(panel);
				panel = new JPanel();
				frame.add(panel);
				frame.requestFocus();

			}

		}

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (int i = 0; i < cloudList.size(); i++) {
			g.setColor(cloudList.get(i).cul);
			g.fillOval(cloudList.get(i).x, cloudList.get(i).y, 100, 100);

		}
		
		double score = molesPressed - seconds/5.0 ;
		//Re-Vamp needed to use molesPressed to Seconds Ratio in more positive score

		g.setFont(font);
		g.setColor(new Color(150, 250, 150));
		g.drawString("Score:" + score + "", 50, 150);
		g.setFont(fontEndScreen);

		g.setColor(new Color(150, 250, 150));
		g.drawString("Game Over", GameCore.WIDTH / 2 - 230, GameCore.HEIGHT / 2 - 103);
		g.setFont(fontRestartText);
		g.drawString("Press Any Key (Except Esc) To Restart...", GameCore.WIDTH / 2 - 330, GameCore.HEIGHT / 2 - 53);
	}

	public void calculateDaClouds() {

		for (int i = 0; i < cloudsX.length; i++) {
			int x = gen.nextInt(1000);
			int y = gen.nextInt(200);
			cloudsX[i] = x;
			cloudsY[i] = y;

		}

	}

	public void makeDaClouds(int y, Color cul) {

		int x = -200;

		for (int i = 0; i < 50; i++) {
			x += gen.nextInt(70) + 30;
			int cY = y + gen.nextInt(50) + -25;

			Cloud daCloud = new Cloud(x, cY, cul);
			cloudList.add(daCloud);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 27) {
			System.exit(0);
		} else {
			frame.remove(panel);
			isOnEndState = false;
			randomize();
			seconds = 0;
			molesPressed = 0;
			nonMolesPressed = 0;
		}
		System.out.println(keyCode);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
