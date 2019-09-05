package game_components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

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
	
	public void update(GameContainer gc) {
		
	}
	
	public void render(Graphics g) {
		image.draw(x, y, width, height);
	}

	public boolean isHovering() {
		boolean is = false;
		if()
		return is;
	}
	
	public boolean isClicked() {
		boolean is = false;
		
		return is;
	}
	
}
