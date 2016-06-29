

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HP extends GameObject{

	public HP(int x, int y, ID id) {
		super(x, y, id);
		
		velX = 3;
		velY = 2;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x == 10000) x = 10000;
		if(y <= 0||y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0||x >= Game.WIDTH - 16) velX *= -1;
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 12, 12);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 12, 12);
	}
	

}
