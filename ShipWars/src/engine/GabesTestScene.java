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
	int mx, my;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		button = new Button(Resources.getImage("character1"), 200, 200);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delts) throws SlickException {
		
		mx = Mouse.getX();
		my = Engine.getHeight() - Mouse.getY()-1;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		button.render(g);
		g.drawString("X: " + mx + ", Y: " + my, 10, 10);
		if(button.isClicked(mx, my, gc)) g.drawString("Click", 10, 30);
		
	}
	
	@Override
	public int getID() {
		
		return States.GABES_TEST_SCENE;
		
	}

}
