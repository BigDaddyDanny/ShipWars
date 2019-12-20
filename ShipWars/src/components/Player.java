package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/*
 * - ideally should take care of controls, character movement and actions
 * 
 */

public class Player {

	private static final int SPEED = 2;
	private static int nextPlayerNumber = 1;
	
	private int x;
	private int y;
	private Image sprite;
	
	private int playerNumber;
	
	public Player(int startX, int startY, Image s) {
		
		 x = startX;
		 y = startY;
		 sprite = s;
		 
		 playerNumber = nextPlayerNumber;
		 nextPlayerNumber++;
		 
	}
	
	
	public void update(GameContainer gc) {
		
		if(playerNumber == 1) {//testing purposes only
			
			if(gc.getInput().isKeyDown(Input.KEY_UP)) {
				y -= SPEED;
			}
			
			if(gc.getInput().isKeyDown(Input.KEY_DOWN)) {
				y += SPEED;
			}
			
			if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
				x -= SPEED;
			}
			
			if(gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
				x += SPEED;
			}
			
			x = x < 0 ? 0 : x;
			y = y < 0 ? 0 : y;
			
			x = x > 1920 ? 1920 : x;
			y = y > 1080 ? 1080 : y;
		
		}
		
	}
	
	public void render(Graphics g) {
		
		sprite.drawCentered(x, y);
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void adjustCoords(int tx, int ty) {
		x += tx;
		y += ty;
	}
	
	public void setCoords(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	
}