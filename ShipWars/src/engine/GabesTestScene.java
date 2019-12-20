package engine;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game_components.Button;

public class GabesTestScene extends BasicGameState{

	Button button;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		button = new Button(Resources.getImage("character1"), 200, 200);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delts) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		button.render(g);
		if(button.isClicked(gc)) g.drawString("Click", 10, 30);
		
	}
	
	@Override
	public int getID() {
		
		return States.GABES_TEST_SCENE;
		
	}

}
