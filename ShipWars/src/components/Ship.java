package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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
	
	public Ship(String n, Turret main, Engines e, Shield s, Hull h, Player[] p) {
		
		hull = h; 
		mainTurret = main;
		eng = e;
		shield = s;
		players = p;
		
		/*
		 * Depending on Hull that Ship has, all coords of other components besides hull need to be adjusted so they are in their proper places
		 * relevant to the hull shape and design
		 */
		
		hull.setCoords(0, 0);
		mainTurret.setCoords(hull.getTurretCoords()[0], hull.getTurretCoords()[1]);
		eng.setCoords(hull.getEngineCoords()[0], hull.getEngineCoords()[1]);
		shield.setCoords(hull.getShieldCoords()[0], hull.getShieldCoords()[1]);	
		
		
	}
	
	public void render(Graphics g) {
		
		hull.render(g);
		mainTurret.render(g);
		eng.render(g);
		shield.render(g);
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
	
	/*
	 * method called to adjust the coords of all components at the start of Game state to move playerTwo ship to the right of the screen
	 */
	public void adjustCoords(int tx, int ty) {
		
		hull.adjustCoords(tx, ty);
		mainTurret.adjustCoords(tx, ty);
		eng.adjustCoords(tx, ty);
		shield.adjustCoords(tx, ty);
		
		for(Player p : players) {
			p.adjustCoords(tx, ty);
		}
		
	}
	
}