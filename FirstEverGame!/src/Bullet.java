import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;


public class Bullet extends Game_Object {

	BufferedImage missile;
	public static int size = 1;
	Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
	
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
		g.drawImage(missile, x, y, width * size, height * size, null);
	}

	public void update() {
		super.update();
		y -= 5;
	}

	
}
