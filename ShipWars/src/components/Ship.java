package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/*
 * - possible future subsystems: medbay, oxygen generator, teleporter, clone chamber, reactor core/energy generator
 * 
 */

public class Ship {
	
	private Turret mainTurret;
	
	private Engines eng;
		
	private Shield shield;
	
	private Hull hull;
	
	public Ship(String n, Turret main, Engines e, Shield sh, Hull h) {
		
		hull = h;
		mainTurret = main;
		eng = e;
		shield = sh;
		
	}
	
	public void render(Graphics g) {
		
		mainTurret.render(g);
		eng.render(g);
		shield.render(g);
		hull.render(g);
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg) {
		
		if(shield.getHealth() <= 0) {
			hull.damage(dmg);
		}else {
			shield.damage(dmg);
		}
		
	}	
	
	public void setCoords(int x, int y) {
		
	}
	
}