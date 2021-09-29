import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy extends Game_Object {

	Random gen = new Random();

	BufferedImage img;
	BufferedImage chatBubble;

	Font font = new Font("Comic Sans MS", Font.BOLD, 15);

	int hp = 900;
	int maxHP = 900;

	long shootTimer;
	long shootCooldown = 6000;

	public boolean isYoshi = false;

	boolean left;
	boolean right;
	boolean down = true;

	Enemy(double x, double y, int width, int height, boolean isYoshi, int hp) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub (done)
		
		this.hp = hp;
		this.maxHP = hp;
		this.isYoshi = isYoshi;

		if (isYoshi == false) {
			img = loadImage("Enemy.png");
		}

		else {
			img = loadImage("HandsomeYoshi.png");
			chatBubble = loadImage("SpikeyChatBubble.Png");
			this.width = 150;
			this.height = 140;

		}
		speed = 1 + GamePanel.currentLevel / 5;

	}

	public void spawnBullet() {
		if (System.currentTimeMillis() - shootTimer > shootCooldown) {
			Cow e = new Cow((x + width / 2) - 20, y + height - 30, 80, 56, isYoshi);
			GamePanel.cowList.add(e);
			shootTimer = System.currentTimeMillis();
		}
	}

	public void draw(Graphics g) {

		g.drawImage(img, (int) x, (int) y, width, height, null);

		double barWidth = (((double) hp / (double) maxHP) * (double) width);
		g.setColor(new Color(150, 0, 50));
		g.drawRect((int) x, (int) y - 40, width, 30);
		g.fillRect((int) x, (int) y - 40, (int) barWidth, 30);
		g.setColor(new Color(255, 255, 255));
		g.setFont(font);
		g.drawString(hp + "/" + maxHP, (int) x + width / 6, (int) y - 18);

		if (isYoshi == true) {
			g.setColor(new Color(0, 0, 0));
			g.setFont(font);
			g.drawImage(chatBubble, (int) x + width - 50, (int) y - 60, width, height, null);
			g.drawString("Brrring HA ;)" + "", (int) x + width - 20, (int) y - 2);
			g.setColor(new Color(50, 140, 0));
		}

		// g.drawString(hp + "", (int)x, (int)y);
	}

	public void update() {
		super.update();
		spawnBullet();
		movement();
		if (y > GameCore.HEIGHT) {
			isAlive = false;
			Game_Player.numLives -= 1;

		}
	}

	public void movement() {

		if (x < 5) {
			left = false;
			down = true;
		}

		if (x > GameCore.WIDTH - width - 5) {
			right = false;
			down = true;
		}

		if (left == true) {

			x -= speed;

		}

		if (right == true) {

			x += speed;

		}

		if (down == true) {
			y += speed;
			int chance = gen.nextInt(300);

			if (chance < 3) {
				down = false;
				if (x < GameCore.WIDTH / 2) {
					right = true;

				}

				if (x > GameCore.WIDTH / 2) {
					left = true;

				}

			}

		}

	}

	BufferedImage loadImage(String fileName) {
		String pathc = Paths.get("").toAbsolutePath().toString();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(pathc + "\\src\\" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return img;
	}

}
