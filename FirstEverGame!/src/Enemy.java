import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Game_Object {

	Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);

	}

	public void update() {
		super.update();
		y++;
	}

}
