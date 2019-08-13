package engine;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Engines;
import components.Hull;
import components.Player;
import components.Shield;
import components.Ship;
import components.Turret;
/*
 * TODO:
 * - add way for player to input name
 */
public class Selection extends BasicGameState{
	
	private static final Image BACKGROUND = Resources.getImage("SpaceBackground1");
	private static final int TURRET_X = 800;
	private static final int TURRET_Y = 900;
	private static final int SHIELD_X = 1400;
	private static final int SHIELD_Y = 20;
	private static final int ENGINE_X = 650;
	private static final int ENGINE_Y = 20;
	private static final int HULL_X = 0;
	private static final int HULL_Y = 20;
	
	//list of types of turrets
	Turret[] turrets = { ComponentLoader.getTurret(0)
	};
	
	Shield[] shields = {ComponentLoader.getShield(0)
			
	};
	
	Engines[] engines = { ComponentLoader.getEngine(0)
			
	};
	
	Hull[] hulls = { ComponentLoader.getHull(0)
			
	};
	
	private int turretCounter = 0;
	private int shieldCounter = 0;
	private int engineCounter = 0;
	private int hullCounter = 0;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		BACKGROUND.draw();
		turrets[turretCounter].getSprite().draw(turrets[turretCounter].getX(), turrets[turretCounter].getY(), 3);
		shields[shieldCounter].render(g);
		engines[engineCounter].render(g);
		hulls[hullCounter].render(g);
		
		g.drawString("Damage: " + String.valueOf(turrets[turretCounter].getDmg()), TURRET_X, TURRET_Y + turrets[turretCounter].getSprite().getHeight() - 60);
		g.drawString("Fire Chance: " + String.valueOf(turrets[turretCounter].getFire()), TURRET_X, TURRET_Y + turrets[turretCounter].getSprite().getHeight() - 80);
		
		g.drawString("Health: " + String.valueOf(hulls[hullCounter].getMaxHealth()), HULL_X, HULL_Y + hulls[hullCounter].getSprite().getHeight() - 40);
		
		g.drawString("Health: " + String.valueOf(shields[shieldCounter].getMaxHealth()), SHIELD_X, SHIELD_Y + shields[shieldCounter].getSprite().getHeight() + 20);
		g.drawString("Recharge Rate: " + String.valueOf(shields[shieldCounter].getRecharge()), SHIELD_X, SHIELD_Y + shields[shieldCounter].getSprite().getHeight() + 40);
		
		g.drawString("Dodge Chance: " + String.valueOf(engines[engineCounter].getDodgeChance()), ENGINE_X, ENGINE_Y + engines[engineCounter].getSprite().getHeight() + 20);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int arg2) throws SlickException {
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){

			if(Game.setShip(new Ship( "temp", ComponentLoader.getTurret(turretCounter), ComponentLoader.getEngine(engineCounter), 
						ComponentLoader.getShield(shieldCounter), ComponentLoader.getHull(hullCounter), new Player[] {new Player(10, 10, Resources.getImage("character1"))} ))) {
				s.enterState(States.GAME);
			
			}
		}
	
	}


	@Override
	public int getID() {
		return States.SELECTION;
	}

}