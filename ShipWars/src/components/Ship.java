package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
/*
 * -subsystems (eg. Shield, Engines, (medbay?), (steering?),
 */
public class Ship {
	
	private int health;
	private int shield;
	private double dodgeChance;
	private Image sprite;
	private int x;
	private int y;
	
	private Turret mainTurret;
	private int mainX;
	private int mainY;
	
	public Ship() {
		
	}
	
	public void render(Graphics g) {
		sprite.drawCentered(x, y);
	}
	
	public void update() {
		
	}

}
