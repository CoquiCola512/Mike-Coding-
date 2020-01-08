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
	public static int numLives = 1 ;
	public static int numScore = 0 ;

	ArrayList<BufferedImage> shipIdle;

	Game_Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		shipIdle = new	ArrayList<BufferedImage>();

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
		g.drawImage(shipIdle.get(frameNum), x, y, width, height, null);
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

}
