package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/*
 * - ideally should take care of controls, character movement and actions
 */

public class Player {

	private static final int SPEED = 2;
	
	private int x;
	private int y;
	private Image sprite;
	
	public Player(int startX, int startY, Image s) {
		
		 x = startX;
		 y = startY;
		 sprite = s;
		 
	}
	
	
	public void update(GameContainer gc) {
		
		int changeX = 0;
		int changeY = 0;
		
		if(gc.getInput().isKeyPressed(Input.KEY_UP)) {
			changeY -= SPEED;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			changeY += SPEED;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_LEFT)){
			changeX -= SPEED;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
			changeX += SPEED;
		}
		
		x += changeX;
		y += changeY;
		
		x = x < 0 ? 0 : x;
		y = y < 0 ? 0 : y;
		
		x = x > 1920 ? 1920 : x;
		y = y > 1080 ? 1080 : x;
		
	}
	
	public void render(Graphics g) {
		
		sprite.draw(x, y);
		
	}
	
	
}
