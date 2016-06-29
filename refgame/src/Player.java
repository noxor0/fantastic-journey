

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject { //tester

	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 50);
		
		collision();
	}

	private void collision(){
		for(int i = 0; i < handler.objectList.size(); i++){
			GameObject tempObject = handler.objectList.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					//collision
					HUD.HEALTH -=2;
				}
			}
			
			if(tempObject.getId() == ID.HP){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH += 10;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		if(id == ID.Player)g.setColor(Color.white);
		else g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

}
