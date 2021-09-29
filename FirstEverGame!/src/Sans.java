
public class Sans extends Enemy {

	
	Sans(double x, double y, int width, int height) {
		super(x, y, width, height, false, 1400);
		// TODO Auto-generated constructor stub
		img = loadImage("Sans.png");
		shootCooldown = 3000;
	  
	}

	public void spawnBullet() {
		if (System.currentTimeMillis() - shootTimer > shootCooldown) {
			Bone e = new Bone((x + width / 2)-20, y + height - 30, 40, 20);
			GamePanel.boneList.add(e);
			shootTimer = System.currentTimeMillis();
		}

	}

	public void update() {
		super.update();
		spawnBullet();
	}

}
