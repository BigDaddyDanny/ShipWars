package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Component {

	protected Image sprite;
	private String name;
	private int x;
	private int y;
	
	protected Component(Image s, String n, int x, int y) {
		sprite = s;
		name = n;
		
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		
		sprite.draw(x, y);
		
	}
	
	public abstract void update();
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public String getName() {
		return name;
	}
	
	public Image getSprite() {
		return sprite;
	}
	
}
