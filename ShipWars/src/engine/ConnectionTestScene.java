package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ConnectionTestScene extends BasicGameState{

	int x, y;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		Resources.getImage("character1").draw(x, y);
		
	}

	@Override
	public int getID() {
		return States.CONNECTION_TEST_SCENE;
	}

}
