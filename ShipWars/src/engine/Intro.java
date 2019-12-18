package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game_components.Button;

public class Intro extends BasicGameState {

	private final Image background = Resources.getImage("SpaceBackground1");
	private final Image titleImage = Resources.getImage("title");
	private Button join, host;
	private int mx = 0, my = 0;

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {

		join = new Button(Resources.getImage("join"), Engine.getWidth()/2-350, Engine.getHeight()/2, Resources.getImage("joinHover"),
				Resources.getImage("joinHover"));
		host = new Button(Resources.getImage("host"), Engine.getWidth()/2+100, Engine.getHeight()/2, Resources.getImage("hostHover"),
				Resources.getImage("hostHover"));

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		my = Engine.getMouseX();
		mx = Engine.getMouseY();
		
		if (join.isClicked(mx, my, gc)) {
			s.enterState(States.NEW_SELECTION);
		}
		if (host.isClicked(mx, my, gc)) {
			s.enterState(States.NEW_SELECTION);
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {

		background.draw();
		g.drawImage(titleImage, Engine.getWidth() / 2 - titleImage.getWidth() / 2, 40);
		join.render(g);
		host.render(g);

	}

	@Override
	public int getID() {
		return States.INTRO;
	}

}