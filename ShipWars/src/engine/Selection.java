package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Engines;
import components.Hull;
import components.Shield;
import components.Turret;

public class Selection extends BasicGameState{
	
	private final Image background = Resources.getImage("SpaceBackground1");
	private static final int TURRET_X = 800;
	private static final int TURRET_Y = 900;
	private static final int SHIELD_X = 1400;
	private static final int SHIELD_Y = 20;
	private static final int ENGINE_X = 650;
	private static final int ENGINE_Y = 20;
	private static final int HULL_X = 0;
	private static final int HULL_Y = 20;
	
	//list of types of turrets
	Turret[] turrets = { new Turret(Resources.getImage("BioBoomer"), "Bio Boomer", TURRET_X, TURRET_Y, 5, 2),
	};
	
	Shield[] shields = {new Shield(Resources.getImage("ExampleShield"), "Example Shield", SHIELD_X, SHIELD_Y, 100, .2),
			
	};
	
	Engines[] engines = { new Engines(Resources.getImage("ExampleEngine"), "Example Engine", ENGINE_X, ENGINE_Y, .5)
			
	};
	
	Hull[] hulls = {	new Hull(Resources.getImage("ExampleHull"), "Example Engine", HULL_X, HULL_Y, 100)
			
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
		
		background.draw();
		turrets[turretCounter].getSprite().draw(turrets[turretCounter].getX(), turrets[turretCounter].getY(), 3);
		shields[shieldCounter].render(g);
		engines[engineCounter].render(g);
		hulls[hullCounter].render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int arg2) throws SlickException {
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			s.enterState(States.SELECTION);
		}
		
	}

	@Override
	public int getID() {
		return States.SELECTION;
	}

}