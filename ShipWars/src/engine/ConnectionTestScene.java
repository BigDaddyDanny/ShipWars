package engine;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Player;

public class ConnectionTestScene extends BasicGameState{

	int x2, y2;
	Player player1;
	String in;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		player1 = new Player(0, 0, Resources.getImage("character1"));
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		try {
			in = Connection.input();
		} catch (IOException e) {
			e.printStackTrace();
		}
		x2 = Integer.parseInt(in.split(",")[0]);
		y2 = Integer.parseInt(in.split(",")[1]);
		
		
		String out = player1.getX() + "," + player1.getY();
		Connection.output(out);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		player1.render(g);
		Resources.getImage("character2").draw(x2, y2);
	}

	@Override
	public int getID() {
		return States.CONNECTION_TEST_SCENE;
	}

}
