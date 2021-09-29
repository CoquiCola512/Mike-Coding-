import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Game_Player extends Game_Object {
	boolean up;
	boolean down;
	boolean right;
	boolean left;
	BufferedImage ship;
	long frameTimer = 0 ;
	long frameCooldown = 50 ;
	int frameNum = 0 ;
	public static int numLives = 100 ;
	public static int numScore = 0 ;
	public static int shieldz = 0;
	public static int bobPower = 1;

	ArrayList<BufferedImage> shipIdle;

	Game_Player(double x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		shipIdle = new	ArrayList<BufferedImage>();
		speed = 10;
		
		loadAnimation();

	}

	void loadAnimation(){
		BufferedImage img = loadImage("SpaceShip_SpriteSheet.png");
		int width = img.getWidth()/2;
		int height = img.getHeight();
		for (int i = 0; i < 2; i ++) {
			shipIdle.add(img.getSubimage(i*width, 0*height, width, height ));
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

	public void draw(Graphics g) {
		//g.setColor(Color.BLACK);
		//g.fillRect(x, y, width, height);
		g.drawImage(shipIdle.get(frameNum), (int) x, (int) y, width, height, null);
		
		if(shieldz > 0) {
			g.setColor(Color.blue);
			g.drawOval((int) x -2, (int) y, width +1, height);
		}
		
	}

	public void update() {
		super.update();
		if (up == true && y > 0) {
			y -= speed;
		}

		if (down == true && y < 950 - height) {
			y += speed;
		}
		if (left == true && x > 0) {
			x -= speed;
		}
		if (right == true && x < 1000 - width) {
			x += speed;
		}
		animate();
	}
	
	void animate(){
		if(System.currentTimeMillis() - frameTimer >= frameCooldown){
			frameTimer = System.currentTimeMillis();
			frameNum ++ ; 
			if(frameNum >= 2 ){
				frameNum = 0;
			}
		}
	}

	public static void takeDamage(int dmg) {
	if (shieldz > 0) {
		shieldz -= dmg;
	}
	
	else {
		numLives --;
	}
		
	}
	
	public void shootz() {
		if (System.currentTimeMillis() - GamePanel.bulletTimer > GamePanel.bulletCooldown) {
			
			GamePanel.bulletTimer = System.currentTimeMillis();
		
			//Old system?
		//for(double i = -bobPower/2; i <=  bobPower/2; i ++){
			//GamePanel.shootzBullet(x , y, i*10);
		//}
			for(double i = 1; i <=  bobPower; i ++){
				double x2 = i - bobPower/2;
				double multiplier = bobPower/i;
				GamePanel.shootzBullet(x + width/2 , y, 0);
				GamePanel.shootzBullet(x + width/2 , y, 7);
				GamePanel.shootzBullet(x + width/2 , y, 10);
				GamePanel.shootzBullet(x + width/2 , y, 12.3);
				GamePanel.shootzBullet(x + width/2 , y, 14.2);
				GamePanel.shootzBullet(x + width/2 , y, 15.8);
				GamePanel.shootzBullet(x + width/2 , y, 17.3);
				GamePanel.shootzBullet(x + width/2 , y, 18.7);
				GamePanel.shootzBullet(x + width/2 , y, 20);
				GamePanel.shootzBullet(x + width/2 , y, 21.3);
				GamePanel.shootzBullet(x + width/2 , y, 22.5);


				// rn 10 looks good but its not gonna be the first B_O_B.
				// numberz: 0, 7, 10, 12.3, 14.2, 15.8, 17.3, 18.7, 20, 21.3, 22.5
			}
			
		}
	}
	
}
