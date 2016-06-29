

import java.awt.Graphics;
import java.util.LinkedList;

//handles objects created
//loops through, updates and renders them
public class Handler { 
	
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.objectList.add(object);
	}
	
	public void removeObject(GameObject object){
		this.objectList.remove(object);
	}

	public void clearEnemies() {
		for(int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			if(tempObject.getId() == ID.Player){
				objectList.clear();
				if(Game.gameState != Game.STATE.End){
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
				}
				
			}
		}
	}
}
