package engine;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Engines;
import components.Hull;
import components.Shield;
import components.Turret;
import game_components.Button;

public class NewSelection extends BasicGameState{
	private static final Image BACKGROUND = Resources.getImage("SpaceBackground1");

	private final int selectionBarSize = 250;
	private final int boxes = 4;
	private final int verticalBoxSize = (int)(Engine.getHeight()/boxes);
	private Button[] upArrows;
	private Button[] downArrows;
	//The 2nd and 3rd of each array is utter garbage and only serve to test name output for selection
	private Hull[] hulls = {ComponentLoader.getHull(0), new Hull(Resources.getImage("ExampleHull"), "Hull Two", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {250, 720, 250, 400, 250, 150}, 3, 3, 100), new Hull(Resources.getImage("ExampleHull"), "Hull Three", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {250, 720, 250, 400, 250, 150}, 3, 3, 100)};
	private Shield[] shields = {ComponentLoader.getShield(0), new Shield(Resources.getImage("ExampleShield"), "Shield Dos", 3, 3, 100, .2), new Shield(Resources.getImage("ExampleShield"), "Shield Tres", 3, 3, 100, .2)};
	private Engines[] engines = {ComponentLoader.getEngine(0), new Engines(Resources.getImage("ExampleEngine"), "Yeet Engine", 3, 3, .5), new Engines(Resources.getImage("ExampleEngine"), "Fast Engine", 3, 3, .5)};
	private Turret[] turrets = {ComponentLoader.getTurret(0), new Turret(Resources.getImage("BioBoomer"), "Bio Thwacker", 3, 3, 5, 2), new Turret(Resources.getImage("BioBoomer"), "Pew Pew Gun", 3, 3, 5, 2)};
	private int hullI = 0, shieldI = 0, engineI = 0, turretI = 0, mx, my;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		upArrows = new Button[boxes];
		downArrows = new Button[boxes];
		for(int i = 0; i < boxes; i++) {
			upArrows[i] = new Button(Resources.getImage("upArrow"), 0, i*verticalBoxSize);
			downArrows[i] = new Button(Resources.getImage("downArrow"), 0, ((i+1)*verticalBoxSize)-Resources.getImage("downArrow").getHeight());
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
		mx = Engine.getMouseX();
		my = Engine.getMouseY();
		
		if(upArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI<hulls.length-1?hullI+1:0;
		}
		if(upArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI<shields.length-1?shieldI+1:0;
		}
		if(upArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI<engines.length-1?engineI+1:0;
		}
		if(upArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI<turrets.length-1?turretI+1:0;
		}
		
		if(downArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI>0?hullI-1:hulls.length-1;
		}
		if(downArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI>0?shieldI-1:shields.length-1;
		}
		if(downArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI>0?engineI-1:engines.length-1;
		}
		if(downArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI>0?turretI-1:turrets.length-1;
		}
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		BACKGROUND.draw();
		Resources.getImage("color").draw(0, 0, selectionBarSize, Engine.getHeight());
		
		//this just makes a comment visible inside the game, in case whoever notices the changes does not look in the code first
		g.drawString("There will be a preview of what the ship will look like\n"
				+ "that will update as you cycle through component options", 900, Engine.getHeight()/2-15);
		
		for(int i = 0; i < boxes; i++) {
			upArrows[i].render(g);
			downArrows[i].render(g);
		}
		g.drawString(hulls[hullI].getName(), 20, verticalBoxSize/2 - 10);
		g.drawString(shields[shieldI].getName(), 20, (verticalBoxSize)+verticalBoxSize/2 - 10);
		g.drawString(engines[engineI].getName(), 20, (2 * verticalBoxSize)+verticalBoxSize/2 - 10);
		g.drawString(turrets[turretI].getName(), 20, (3 * verticalBoxSize)+verticalBoxSize/2 - 10);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.NEW_SELECTION;
	}

}
