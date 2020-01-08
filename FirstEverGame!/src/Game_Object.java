import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Game_Object {
	int x;
	int y;
	int width;
	int height;
	int speed = 10;
	boolean isAlive = true;
	Rectangle collisionBox;
	Game_Object(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isAlive = true;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	
	}
	
	public void update(){
		collisionBox.setBounds(x, y, width, height);
	}
	
}

