package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/*
 * - possible future subsystems: medbay, oxygen generator, teleporter, clone chamber, reactor core/energy generator
 * 
 */

public class Ship {
	
	private String name;
	private int health;
	private Image sprite;
	private int x;
	private int y;
	
	private Turret mainTurret;
	
	private Engines eng;
		
	private Shield shield;
	
	public Ship(Image s, int x, int y, String n, Turret main, Engines e, Shield sh) {
		
		health = 100;
		this.x = x;
		this.y = y;
		name = n;
		mainTurret = main;
		eng = e;
		shield = sh;
		
	}
	
	public void render(Graphics g) {
		sprite.drawCentered(x, y);
		
		mainTurret.render(g);
		eng.render(g);
		shield.render(g);
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg) {
		if(shield.getHealth() <= 0) {
			health -= dmg;
		}else {
			shield.damage(dmg);
		}
		
	}

	
}
