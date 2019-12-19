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

		int spacing = 100;
		join = new Button(Resources.getImage("join"), (Engine.getWidth()/2-Resources.getImage("join").getWidth())-spacing/2, Engine.getHeight()/2, Resources.getImage("joinHover"),
				Resources.getImage("join"));
		host = new Button(Resources.getImage("host"), (Engine.getWidth()/2)+spacing/2, Engine.getHeight()/2, Resources.getImage("hostHover"),
				Resources.getImage("host"));

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		mx = Engine.getMouseX();
		my = Engine.getMouseY();
		
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
		
		g.drawString("X: " + mx + ", Y: " + my, 10, 10);

	}

	@Override
	public int getID() {
		return States.INTRO;
	}

}