package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
/*
 * - possible future subsystems: medbay, oxygen generator, teleporter, clone chamber, reactor core/energy generator
 * 
 */

public class Ship {
	
	private int health;
	private int shield;
	private Image sprite;
	private int x;
	private int y;
	
	private Turret mainTurret;
	private int mainX;
	private int mainY;
	
	private Engines eng;
	private int engX;
	private int engY;
		
	private Shield 
	public Ship() {
		
		
		
		
		
	}
	
	public void render(Graphics g) {
		sprite.drawCentered(x, y);
		
		mainTurret.render(g);
		eng.render(g);
		
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg) {
		if()
	}

	
}
