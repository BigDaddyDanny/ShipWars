package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Ship;

public class Game extends BasicGameState{
	
	private static final Image BACKGROUND = Resources.getImage("SpaceBackground1");
	private static Ship playerOne;
	private static Ship playerTwo;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		BACKGROUND.draw();
		playerOne.render(g);
		playerTwo.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
		playerOne.update(gc);
		playerTwo.update(gc);
		
	}
	
	public static boolean setShip(Ship ship) {
		if(playerOne == null) {
			playerOne = ship;
//			playerOne.setCoords(0, 0);
			return false;
		}else {
			playerTwo = ship;
//			playerTwo.setCoords(950, 0);
			return true;
		}
	}

	@Override
	public int getID() {
		return States.GAME;
	}

}
