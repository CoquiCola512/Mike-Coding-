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
	Timer timer = new Timer(1000 / 60, this);
	Game_Player player;
	Enemy enemy;
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Cloud> cloudList = new ArrayList<Cloud>();
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Character> charList = new ArrayList<Character>();
	
	long spawnTimer;
	long spawnCooldown = 3000;
	long bulletTimer;
	long bulletCooldown = 700;
	public static int currentState = 0;
	public static final int GAME_STATE = 0;
	public static final int END_STATE = 1;
	Random gen = new Random();

	GamePanel() {
		player = new Game_Player(60, 650, 80, 70);
		enemy = new Enemy(70, 70, 90, 80);
		timer.start();
	}

	public void spawnEnemies() {
		if (System.currentTimeMillis() - spawnTimer > spawnCooldown) {
			Enemy e = new Enemy(new Random().nextInt(932), 0, 90, 80);
			enemyList.add(e);
			spawnTimer = System.currentTimeMillis();
		}

	}

	public void spawnBullet() {
		if (System.currentTimeMillis() - bulletTimer > bulletCooldown) {
			Bullet e = new Bullet(player.x + player.width/7, player.y, 20, 40);
			Bullet e2 = new Bullet(player.x + player.width/2, player.y, 20, 40);

			bulletList.add(e);
			bulletList.add(e2);
			bulletTimer = System.currentTimeMillis();
		}

	}

	public void checkCollisions() {

		for (int i = enemyList.size() - 1; i >= 0; i--) {

			if (enemyList.get(i).collisionBox.intersects(player.collisionBox)) {
				Game_Player.numLives--;
				enemyList.get(i).isAlive = false;
				
			}

			else {
				for (int b = bulletList.size() - 1; b >= 0; b--) {

					if (enemyList.get(i).collisionBox.intersects(bulletList
							.get(b).collisionBox) && enemyList.get(i).isAlive) {
						bulletList.get(b).isAlive = false;
						enemyList.get(i).isAlive = false;
					}
				}
			}

		}

	}

	public void purgeObjects() {
		for (int b = bulletList.size() - 1; b >= 0; b--) {
			if(!bulletList.get(b).isAlive){
				bulletList.remove(b);
			}
		}
		for (int i = enemyList.size() - 1; i >= 0; i--) {
			if(!enemyList.get(i).isAlive){
				enemyList.remove(i);
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
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 950);
		player.draw(g);
		g.setFont(font);
		g.drawString("Score:" + Game_Player.numScore + "", 20, 75);
		g.drawString("Lives:" + Game_Player.numLives + "", 20, 40);
		for (Enemy e : enemyList) {
			e.draw(g);
		}

		for (Bullet b : bulletList) {
			b.draw(g);
		}
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 1000, 950);

		for (int i = 0; i < cloudList.size(); i++) {
			g.setColor(cloudList.get(i).cul);
			g.fillOval(cloudList.get(i).x, cloudList.get(i).y, 100, 100);
		}

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

	public void checkCheats(){
		if(charList.size()>20){ 
			charList.remove(0);
			
		}
	
		String cheat = "";
		
		
		for(Character c : charList) {
			cheat += c;
		
		}
		
		if(cheat.contains("bigbob")){
			Bullet.size = 2;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
		enemy.update();
		spawnEnemies();
		checkCollisions();
		purgeObjects();
		for (Bullet b : bulletList) {
			b.update();

		}

		for (Enemy e : enemyList) {
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
			spawnBullet();
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
