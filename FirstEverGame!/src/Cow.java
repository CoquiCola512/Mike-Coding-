


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Cow extends Game_Object{
	
	BufferedImage cow;
	public static int size = 1;
	boolean isEgg = false;
	
	Cow(double x, double y, int width, int height, boolean isEgg) {
		super(x, y, width, height);
		speed = 5;
		this.isEgg = isEgg;
		if(isEgg == false) {
			cow = loadImage("UFO_Cow.png");	
		
		}
		
		else {
			cow = loadImage("HandsomeYoshiEgg.png");
			this.width = 70;
			this.height = 90;
		}
		
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
		// g.setColor(Color.BLACK);
		// g.fillOval(x, y, width, height);
		g.drawImage(cow, (int) x, (int) y, width * size, height * size, null);
	}

	public void update() {
		super.update();
		y += speed;
	}

}
