package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Engines {
	
	private double dodgeChance;
	private Image sprite;
	private int x;
	private int y;
	
	public Engines(Image s, double dc, int x, int y) {
		sprite = s;
		dodgeChance = dc;
		
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		sprite.drawCentered(x, y);
	}
	
	public void update() {
		
	}
	
	public double getDodgeChance() {
		return dodgeChance;
	}
	
}
