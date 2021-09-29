import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PowerUp extends Game_Object {

	
	int type;
	BufferedImage img;
	PowerUp(double x, double y, int width, int height, int type) {
		super(x, y, width, height);
		this.type = type;
		this.speed = 1;
		if(type == 0) {
			img = loadImage("PowerUpLives.png");
		}
		else if(type == 1){
			img = loadImage("PowerUpShield.png");
		}
		
		else if(type == 2){
			img = loadImage("PowerUpB_O_B.png");
		}
	}


	public void draw(Graphics g){
		g.drawImage(img, (int) x, (int) y, width, height, null);

	}

	public void update() {
		super.update();
		y += speed;
	}

	public void getPowerUp() {
		if(type == 0) {
		Game_Player.numLives += 10;
		}
		
		else if(type == 1) {
			Game_Player.shieldz += 5;
			}
		
		else if(type == 2) {
			Game_Player.bobPower += 1;
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
