import java.awt.Dimension;

import javax.swing.JFrame;

public class GameCore {

	public static final int WIDTH = 1022;
	public static final int  HEIGHT = 1006;
	public static void main(String[] args) {
		GameCore core = new GameCore();
		core.setUp();
		
	}

	void setUp() {
		JFrame frame = new JFrame();
		GamePanel gPanel = new GamePanel();
		frame.setVisible(true);
		frame.add(gPanel);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.addKeyListener(gPanel);
		frame.pack();
	}
}
