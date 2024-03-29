import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class Bullet extends Game_Object {
	double hDrift;
	BufferedImage missile;
	public static int size = 1;
	Bullet(double x, double y, int width, int height, double hDrift) {
		super(x, y, width, height);
	speed = 5;
	this.hDrift = hDrift;
		missile = loadImage("B_O_B.png");
		
		// TODO Auto-generated constructor stub
		
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
		//g.fillOval(x, y, width, height);
		g.drawImage(missile, (int) x, (int) y, width * size, height * size, null);
	}

	public void update() {
		super.update();
		y -= speed;
		x += hDrift;
		
		if(hDrift >= 1) {
			hDrift = hDrift - 1;
		}
		
		else if(hDrift <= -1) {
			hDrift = hDrift + 1;
		}
		
		else   {
			hDrift = 0;
		}
		
	}

	
	
	
}
