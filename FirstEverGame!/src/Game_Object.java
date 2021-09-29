import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Game_Object {
	double x;
	double y;
	int width;
	int height;
	double speed = 10;
	boolean isAlive = true;
	Rectangle collisionBox;
	Game_Object(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isAlive = true;
		this.collisionBox = new Rectangle((int) x, (int) y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect((int) x, (int) y, width, height);
	
	}
	
	public void update(){
		collisionBox.setBounds((int) x, (int) y, width, height);
	}
	
}

