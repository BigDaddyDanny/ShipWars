package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Engines {
	
	private double dodgeChance;
	private Image sprite;
	private int x;
	private int y;
	/*
	 * @param dc should be number between 0 - 1 where 1 represents 100% chance to dodge
	 */
	public Engines(Image s, int x, int y, double dc) {
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
