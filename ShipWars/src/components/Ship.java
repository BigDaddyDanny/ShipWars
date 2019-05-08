package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/*
 * - possible future subsystems: medbay, oxygen generator, teleporter, clone chamber, reactor core/energy generator
 * 
 */

public class Ship {
	
	private Player[] players;
	
	private Turret mainTurret;
	
	private Engines eng;
		
	private Shield shield;
	
	private Hull hull;
	
	public Ship(String n, Turret main, Engines e, Shield sh, Hull h, Player[] p) {
		
		hull = h;
		mainTurret = main;
		eng = e;
		shield = sh;
		players = p;
		
	}
	
	public void render(Graphics g) {
		
		mainTurret.render(g);
		eng.render(g);
		shield.render(g);
		hull.render(g);
		for(Player p : players) {
			p.render(g);
		}
		
	}
	
	public void update(GameContainer gc) {
		mainTurret.update();
		eng.update();
		shield.update();
		hull.update();
		for(Player p : players) {
			p.update(gc);
		}
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