import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Bone extends Game_Object {

	BufferedImage bone;
	public static int size = 1;

	Bone(double x, double y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		bone = loadImage("Bone.Png");

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
		g.drawImage(bone, (int) x, (int) y, width * size, height * size, null);
	}

	public void update() {
		super.update();
		y += speed;
	}

}
