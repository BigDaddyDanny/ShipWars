package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Intro extends BasicGameState{
	
	private final Image background = Resources.getImage("space_background1");
	private final String GREETING = "Press Enter To Begin";

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		background.draw();
		g.drawString(GREETING, (Engine.getWidth() / 2) - ((GREETING.length() / 2) * 9), Engine.getHeight() / 2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		return States.INTRO;
	}

}
