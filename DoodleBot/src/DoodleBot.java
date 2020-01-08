import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DoodleBot implements MouseListener {
	BufferedImage image;
	Color stripeColor1 = Color.RED;
	Color stripeColor2 = Color.WHITE;
	Color squareColor = Color.BLUE;
	JLabel label = new JLabel();
	JFrame frame = new JFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoodleBot CaL = new DoodleBot();
		CaL.setup();
	}

	private void setup() {
		// TODO Auto-generated method stub
		image = new BufferedImage(1900, 975, BufferedImage.TYPE_INT_RGB);
		frame.addMouseListener(this);

		draw();
		showImage();

	}
	public void draw() {
		drawSquare(0, 0, 1900, 75, stripeColor1);
		drawSquare(0, 75, 1900, 75, stripeColor2);
		drawSquare(0, 150, 1900, 75, stripeColor1);
		drawSquare(0, 225, 1900, 75, stripeColor2);
		drawSquare(0, 300, 1900, 75, stripeColor1);
		drawSquare(0, 375, 1900, 75, stripeColor2);
		drawSquare(0, 450, 1900, 75, stripeColor1);
		drawSquare(0, 525, 1900, 75, stripeColor2);
		drawSquare(0, 600, 1900, 75, stripeColor1);
		drawSquare(0, 675, 1900, 75, stripeColor2);
		drawSquare(0, 750, 1900, 75, stripeColor1);
		drawSquare(0, 825, 1900, 75, stripeColor2);
		drawSquare(0, 900, 1900, 75, stripeColor1);
		drawSquare(0, 0, 700, 525, squareColor);
		drawStars();
	}

	void drawSquare(int sx, int sy, int width, int height, Color c) {
		int color = makeColor(c.getRed(), c.getGreen(), c.getBlue());
		for (int x = sx; x < sx + width; x++) {
			for (int y = sy; y < sy + height; y++) {
				image.setRGB(x, y, color);

			}

		}
	}

	void drawStars() {
		for (int y = 58; y < 430; y += 140 ){
			
			for (int x = 15; x < 640; x += 77) {
				drawStar(x,y,stripeColor2);
			}
			for (int x = 53; x < 630; x += 77) {
				drawStar(x,y+70,stripeColor2);
			}	
		}
		
	}

	void drawStar(int x, int y, Color c) {
		int color = makeColor(c.getRed(), c.getGreen(), c.getBlue());
		int[] buffer = { 24, 23, 23, 22, 22, 21, 21, 20, 20, 19, 19, 18, 18,
				17, 17, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,13,
				13,12,12,12,11,11,10,10,10,9,9,8,8,8,7,7,6,6,6};
		int[] pixels = { 1, 3, 3, 5, 5, 7, 7, 9, 9, 11, 11, 13, 13, 15, 15, 50,
				48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22,23,24,25,
				26,26,27,28,29,30,30,31,32,33,34,34,35,36,37,38,38};
		for (int i = 0; i < buffer.length; i++) {
			for (int k = 0; k < pixels[i]; k++) {
				image.setRGB(x + buffer[i] + k, y + i, color);
			}
		}
		drawTriangle(x, y + 36, squareColor);
	}

	void drawTriangle(int x, int y, Color c) {
		int color = makeColor(c.getRed(), c.getGreen(), c.getBlue());
		int[] buffer = {24,23,22,21,19,18,17,15,14,13,12,10,9,8,6};
		int[] pixels = {1, 4, 7, 9,12,14,17,19,22,25,27,30,32,35,37};
	
		for (int i = 0; i < buffer.length; i++) {
			for (int k = 0; k < pixels[i]; k++) {
				image.setRGB(x + buffer[i] + k, y + i, color);
			}
		}

	}

	int makeColor(int red, int green, int blue) {
		int rgb = (red << 16) | (green << 8) | (blue & 0xFF);
		return rgb;
	}

	void showImage() {
	    label = new JLabel(new ImageIcon(image));
	    frame.add(label);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		setColor(1);
		setColor(2);
		setColor(3);
		frame.remove(label);
		draw();
		showImage();

	}

 public void setColor(int colorChange) {
	 Random numberGen = new Random();
		int red = numberGen.nextInt(255);
		int green = numberGen.nextInt(255);
		int blue = numberGen.nextInt(255);
		Color randomColor = new Color(red,green,blue);
		if (colorChange == 1) {
			stripeColor1 = randomColor;	
		}
		if (colorChange == 2) {
			stripeColor2 = randomColor;	
		}
		if (colorChange == 3) {
			squareColor = randomColor;	
		}
 }
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
