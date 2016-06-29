

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Game.STATE;

public class Menu extends MouseAdapter {
	
	private int halfW = Game.WIDTH / 2;
	
	private Game game;
	private Handler handler;

	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu){ // 'play button'
			if(mouseOver(mx, my, halfW - 100, 100, 200, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler)); //have player class, so that key input cycles through players not objects
				handler.addObject(new BasicEnemy(Game.WIDTH-100,Game.HEIGHT-72, ID.BasicEnemy, handler));
			}			
		}
		
		if(game.gameState == STATE.Menu){ // 'help button'
			if(mouseOver(mx, my,halfW - 100, 200, 200, 64)){
				game.gameState = STATE.Help;
			}			
		}
		
		if(game.gameState == STATE.Menu){ // 'quit button'
			if(mouseOver(mx, my,halfW - 100, 300, 200, 64)){
				System.exit(1);
			}			
		}
		
		if(game.gameState == STATE.Help){ // 'back button'
			if(mouseOver(mx, my,halfW - 100, 600, 200, 64)){
				game.gameState = STATE.Menu;
				return;
			}
		if(game.gameState == STATE.End){ // 'back button'
			if(mouseOver(mx, my,halfW - 100, 600, 200, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler)); //have player class, so that key input cycles through players not objects
				handler.addObject(new BasicEnemy(Game.WIDTH-100,Game.HEIGHT-72, ID.BasicEnemy, handler));
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Menu", Game.WIDTH / 2 - 65, 50);
			
			g.setFont(fnt2);
			g.drawRect(halfW - 100, 100, 200, 64);
			g.drawString("Play", Game.WIDTH / 2 - 85, 142);
			
			g.drawRect(halfW - 100, 200, 200, 64);
			g.drawString("Help", Game.WIDTH / 2 - 85, 242);
			
			g.drawRect(halfW - 100, 300, 200, 64);
			g.drawString("Quit", Game.WIDTH / 2 - 85, 342);
		}
		if(game.gameState == STATE.Help){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Help", halfW - 50, 100);
			
			g.setFont(fnt2);
			g.drawRect(halfW - 100, 600, 200, 64);
			g.drawString("Back", halfW - 60, 645);
			
			g.setFont(fnt2);
			g.drawString("Shoot shit", 20 , 300);
			
		}
		if(game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setColor(Color.white);
			g.setFont(fnt);
			g.drawString("Game Over", halfW - 50, 100);
			
			g.setFont(fnt2);
			g.drawRect(halfW - 100, 600, 200, 64);
			g.drawString("Try Again", halfW - 60, 645);
			
			g.setFont(fnt2);
			g.drawString("Noob" , 20 , 300);
			
		}
	}
	
	public void tick(){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}

}
