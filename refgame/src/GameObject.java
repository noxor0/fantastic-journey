

import java.awt.Graphics;
import java.awt.Rectangle;

//information used by all objects; this is extended
//help handler know how to handle it
public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velX, velY;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(); // this deals with tick
	public abstract void render(Graphics g); // this renders created object
	public abstract Rectangle getBounds();

//getters and setters
	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public float getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
}
