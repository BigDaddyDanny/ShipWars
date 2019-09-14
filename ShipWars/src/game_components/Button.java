package game_components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Button {

	private Image image;
	private int x, y, width, height;
	
	public Button(Image image, int x, int y, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Button(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	public void update(GameContainer gc) {
		
	}
	
	public void render(Graphics g) {
		image.draw(x, y, width, height);
	}

	public boolean isHovering(int mx, int my) {
		return (mx > x && mx < x+width) && (my > y && my < y+height);
	}
	
	public boolean isClicked(int mx, int my, GameContainer gc) {
		return isHovering(mx, my) && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON);
	}
	
}
