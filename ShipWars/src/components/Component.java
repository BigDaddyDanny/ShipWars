package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Component {

	protected Image sprite;
	private String name;
	private final int X;
	private final int Y;
	
	protected Component(Image s, String n, int x, int y) {
		sprite = s;
		name = n;
		
		this.X = x;
		this.Y = y;
	}
	
	public void render(Graphics g) {
		
		sprite.draw(X, Y);
		
	}
	
	public abstract void update();
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	public String getName() {
		return name;
	}
	
	public Image getSprite() {
		return sprite;
	}
	
}
