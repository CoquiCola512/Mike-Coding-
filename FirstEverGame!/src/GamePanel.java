import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	int[] cloudsX = new int[130];
	int[] cloudsY = new int[130];

	Font font = new Font("Comic Sans MS", Font.BOLD, 40);
	Font fontEndScreen = new Font("Comic Sans MS", Font.BOLD, 80);
	Timer timer = new Timer(1000 / 60, this);
	Timer powerupTimer = new Timer(20000, this);
	Game_Player player;

	boolean isYoshiActive = false;

	public static ArrayList<Bone> boneList = new ArrayList<Bone>();
	public static ArrayList<Cow> cowList = new ArrayList<Cow>();
	public static ArrayList<PowerUp> powerUpList = new ArrayList<PowerUp>();
	static ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Character> charList = new ArrayList<Character>();
	ArrayList<Cloud> cloudList = new ArrayList<Cloud>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

	long frameCount = 0;
	long spawnTimer;
	long spawnTimerPowerUps;
	long spawnCooldown = 3000;
	long spawnCooldownPowerUps = 5000;
	static long bulletTimer;
	static long bulletCooldown = 700;
	public static int currentLevel = 1;
	public static int currentState = 0;
	public static final int GAME_STATE = 0;
	public static final int END_STATE = 1;
	Random gen = new Random();

	GamePanel() {
		player = new Game_Player(60, 650, 80, 70);
		timer.start();
	}

	public void spawnEnemies() {
		if (System.currentTimeMillis() - spawnTimer > spawnCooldown) {

			spawnTimer = System.currentTimeMillis();

			if (currentLevel % 5 == 0) {
				Sans s = new Sans(new Random().nextInt(932), 0, 90, 80);
				enemyList.add(s);
			}

			else {
				Enemy e = new Enemy(new Random().nextInt(932), 0, 90, 80, isYoshiActive, 150 + (currentLevel * 50));
				enemyList.add(e);
			}

		}

	}

	public void spawnPowerUps() {
		if (System.currentTimeMillis() - spawnTimerPowerUps > spawnCooldownPowerUps) {

			spawnTimerPowerUps = System.currentTimeMillis();
			PowerUp e = new PowerUp(new Random().nextInt(932), 0, 90, 80, new Random().nextInt(3));
			powerUpList.add(e);

			
		}

	}

	
	
	public static void shootzBullet(double x, double y, double hDrift ) {
		
			Bullet e = new Bullet(x - 10, y, 20, 40, hDrift);
			
			bulletList.add(e);
			
			
		
	}

	public void checkCollisions() {

		for (int i = boneList.size() - 1; i >= 0; i--) {

			if (boneList.get(i).collisionBox.intersects(player.collisionBox)) {
				Game_Player.takeDamage(3);
				boneList.get(i).isAlive = false;

			}

		}

		for (int i = cowList.size() - 1; i >= 0; i--) {

			if (cowList.get(i).collisionBox.intersects(player.collisionBox)) {
				Game_Player.takeDamage(1);
				cowList.get(i).isAlive = false;

			}

		}

		for (int i = powerUpList.size() - 1; i >= 0; i--) {

			if (powerUpList.get(i).collisionBox.intersects(player.collisionBox)) {

				powerUpList.get(i).getPowerUp();
				powerUpList.get(i).isAlive = false;

			}

		}

		for (int i = enemyList.size() - 1; i >= 0; i--) {

			if (enemyList.size() > 0 && enemyList.get(i).collisionBox.intersects(player.collisionBox)) {
				Game_Player.takeDamage(5);
				enemyList.get(i).isAlive = false;

			}

			else {
				for (int b = bulletList.size() - 1; b >= 0; b--) {

					if (enemyList.size() > 0 && enemyList.get(i).collisionBox.intersects(bulletList.get(b).collisionBox)
							&& enemyList.get(i).isAlive) {
						bulletList.get(b).isAlive = false;
						enemyList.get(i).hp -= 100;
						if (enemyList.get(i).hp <= 0) {
							enemyList.get(i).isAlive = false;
							Game_Player.numScore++;

							if (Game_Player.numScore % 10 == 0) {
								currentLevel += 1;
								enemyList.clear();
								frameCount = 0;
								break;
							}

						}

					}
				}
			}

		}

	}

	public void purgeObjects() {
		for (int b = bulletList.size() - 1; b >= 0; b--) {
			if (!bulletList.get(b).isAlive) {
				bulletList.remove(b);
			}
		}

		for (int b = cowList.size() - 1; b >= 0; b--) {
			if (!cowList.get(b).isAlive) {
				cowList.remove(b);
			}
		}

		for (int b = boneList.size() - 1; b >= 0; b--) {
			if (!boneList.get(b).isAlive) {
				boneList.remove(b);
			}
		}

		for (int i = enemyList.size() - 1; i >= 0; i--) {
			if (!enemyList.get(i).isAlive) {
				enemyList.remove(i);
			}
		}
		
		for (int i = powerUpList.size() - 1; i >= 0; i--) {
			if (!powerUpList.get(i).isAlive) {
				powerUpList.remove(i);
			}
		}

	}

	public void paintComponent(Graphics g) {
		if (GAME_STATE == currentState) {
			drawGameState(g);
		}

		else if (currentState == END_STATE) {
			drawEndState(g);

		}
	}

	public void drawGameState(Graphics g) {
		g.setColor(new Color(0, 0, 45));
		g.fillRect(0, 0, GameCore.WIDTH, GameCore.HEIGHT);
		player.draw(g);
		g.setFont(font);
		g.setColor(new Color(0, 205, 205));
		g.drawString("Score:" + Game_Player.numScore + "", 20, 75);
		g.drawString("Lives:" + Game_Player.numLives + "", 20, 40);

		for (Enemy e : enemyList) {
			e.draw(g);
		}

		for (Bullet b : bulletList) {
			b.draw(g);
		}

		for (Bone e : boneList) {
			e.draw(g);
		}

		for (Cow e : cowList) {
			e.draw(g);
		}

		for (PowerUp e : powerUpList) {
			e.draw(g);
		}

		if (frameCount < 200) {
			g.setFont(fontEndScreen);
			g.setColor(new Color(0, 205, 205));
			g.drawString("Level " + currentLevel + "", GameCore.WIDTH / 2 - 150, GameCore.HEIGHT / 2 - 90);
		}

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, GameCore.WIDTH, GameCore.HEIGHT);

		for (int i = 0; i < cloudList.size(); i++) {
			g.setColor(cloudList.get(i).cul);
			g.fillOval(cloudList.get(i).x, cloudList.get(i).y, 100, 100);

		}

		g.setFont(font);
		g.setColor(new Color(150, 250, 150));
		g.drawString("Score:" + (currentLevel * 11 + Game_Player.numScore) + "", 20, 150);
		g.setFont(fontEndScreen);
		g.setColor(new Color(150, 250, 150));
		g.drawString("Game Over", GameCore.WIDTH / 2 - 230, GameCore.HEIGHT / 2 - 103);

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

	public void checkCheats() {
		if (charList.size() > 20) {
			charList.remove(0);

		}

		String cheat = "";

		for (Character c : charList) {
			cheat += c;

		}

		if (cheat.contains("bigbob")) {
			Bullet.size = 2;
			charList.clear();
		}

		if (cheat.contains("yoshi")) {
			isYoshiActive = !isYoshiActive;
			charList.clear();
		}

		if (cheat.contains("lvlup")) {
			Game_Player.numScore = 0;
			currentLevel += 1;
			enemyList.clear();
			frameCount = 0;
			charList.clear();
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		frameCount += 1;

		if (frameCount % 200 == 0) {
			// spawnCooldown -= 250;
			spawnCooldown = 5000 / currentLevel;

		}

		if (GAME_STATE == currentState) {
			updateGameState();
		}

		else if (currentState == END_STATE) {
			updateEndState();

		}
		repaint();

	}

	public void updateGameState() {
		player.update();
		spawnEnemies();
		checkCollisions();
		purgeObjects();
		spawnPowerUps();
		for (Bullet b : bulletList) {
			b.update();
		}

		for (Enemy e : enemyList) {
			e.update();
		}

		for (Bone e : boneList) {
			e.update();
		}

		for (Cow e : cowList) {
			e.update();
		}

		for (PowerUp e : powerUpList) {
			e.update();
		}

		if (Game_Player.numLives <= 0) {
			// calculateDaClouds();
			int blue = 255;
			int red = 0;
			int green = 0;
			for (int y = 50; y < GameCore.HEIGHT; y += 30) {
				Color culMKtwo = new Color(red, green, blue);
				blue -= 7;
				red += 7;
				green += 2;
				makeDaClouds(y, culMKtwo);
			}

			currentState++;

		}

	}

	public void updateEndState() {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int keyPressed = arg0.getKeyCode();
		char charPressed = arg0.getKeyChar();
		charList.add(charPressed);
		checkCheats();
		System.out.println(keyPressed);
		if (keyPressed == 65) {
			player.left = true;
		}
		if (keyPressed == 87) {
			player.up = true;
		}
		if (keyPressed == 68) {
			player.right = true;
		}
		if (keyPressed == 83) {
			player.down = true;
		}
		if (keyPressed == 10) {
			currentState++;
		}

		if (keyPressed == 32) {
			player.shootz();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int keyPressed = arg0.getKeyCode();
		System.out.println(keyPressed);
		if (keyPressed == 65) {
			player.left = false;
		}
		if (keyPressed == 87) {
			player.up = false;
		}
		if (keyPressed == 68) {

			player.right = false;
		}
		if (keyPressed == 83) {
			player.down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
