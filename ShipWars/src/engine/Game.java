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
		
//		playerOne.update();
//		playerTwo.update();
		
	}
	
	public static boolean setShip(Ship ship) {
		if(playerOne == null) {
			playerOne = ship;
			return false;
		}else {
			playerTwo = ship;
			return true;
		}
	}

	@Override
	public int getID() {
		return States.GAME;
	}

}
