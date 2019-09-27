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

public class NewSelection extends BasicGameState {
	private static final Image BACKGROUND = Resources.getImage("SpaceBackground1");

	private final int selectionBarSize = 250;
	private final int boxes = 4;
	private final int verticalBoxSize = (int) (Engine.getHeight() / boxes);
	private Button[] upArrows;
	private Button[] downArrows;
	// The 2nd and 3rd of each array is utter garbage and only serve to test name
	// output for selection
	private Hull[] hulls = { ComponentLoader.getHull(0), ComponentLoader.getHull(1), ComponentLoader.getHull(2) };
	private Shield[] shields = { ComponentLoader.getShield(0), ComponentLoader.getShield(1), ComponentLoader.getShield(2) };
	private Engines[] engines = { ComponentLoader.getEngine(0),
			new Engines(Resources.getImage("ExampleEngine"), "Yeet Engine", 3, 3, .5),
			new Engines(Resources.getImage("ExampleEngine"), "Fast Engine", 3, 3, .5) };
	private Turret[] turrets = { ComponentLoader.getTurret(0), ComponentLoader.getTurret(1),
			ComponentLoader.getTurret(2) };
	private int hullI = 0, shieldI = 0, engineI = 0, turretI = 0, mx, my;
	private int displayBoxW;
	private int[] hullCoords;
	private int[] turretCoords;
	private int[] shieldCoords;
	private int[] engineCoords;

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {

		hullCoords = new int[2];
		shieldCoords = new int[2];
		engineCoords = new int[2];
		turretCoords = new int[2];
		displayBoxW = Engine.getWidth() - selectionBarSize;

		upArrows = new Button[boxes];
		downArrows = new Button[boxes];
		for (int i = 0; i < boxes; i++) {
			upArrows[i] = new Button(Resources.getImage("upArrow"), 0, i * verticalBoxSize, Resources.getImage("upArrowHover"), Resources.getImage("upArrow"));
			downArrows[i] = new Button(Resources.getImage("downArrow"), 0,
					((i + 1) * verticalBoxSize) - Resources.getImage("downArrow").getHeight(), Resources.getImage("downArrowHover"), Resources.getImage("downArrow"));
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

		mx = Engine.getMouseX();
		my = Engine.getMouseY();

		hullCoords[0] = (selectionBarSize + displayBoxW / 2) - (hulls[hullI].getSprite().getWidth() / 2);
		hullCoords[1] = Engine.getHeight() / 2 - (hulls[hullI].getSprite().getHeight() / 2);
		shieldCoords[0] = hullCoords[0] + hulls[hullI].getShieldCoords()[0] - shields[shieldI].getSprite().getWidth()/2;
		shieldCoords[1] = hullCoords[1] + hulls[hullI].getShieldCoords()[1] - shields[shieldI].getSprite().getHeight()/2;
		turretCoords[0] = hullCoords[0] + hulls[hullI].getTurretCoords()[0] - turrets[turretI].getSprite().getWidth()/2;
		turretCoords[1] = hullCoords[1] + hulls[hullI].getTurretCoords()[1] - turrets[turretI].getSprite().getHeight()/2;
		engineCoords[0] = hullCoords[0] + hulls[hullI].getEngineCoords()[0] - engines[engineI].getSprite().getWidth()/2;
		engineCoords[1] = hullCoords[1] + hulls[hullI].getEngineCoords()[1] - engines[engineI].getSprite().getHeight()/2;

		if (upArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI < hulls.length - 1 ? hullI + 1 : 0;
		}
		if (upArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI < shields.length - 1 ? shieldI + 1 : 0;
		}
		if (upArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI < engines.length - 1 ? engineI + 1 : 0;
		}
		if (upArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI < turrets.length - 1 ? turretI + 1 : 0;
		}

		if (downArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI > 0 ? hullI - 1 : hulls.length - 1;
		}
		if (downArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI > 0 ? shieldI - 1 : shields.length - 1;
		}
		if (downArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI > 0 ? engineI - 1 : engines.length - 1;
		}
		if (downArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI > 0 ? turretI - 1 : turrets.length - 1;
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		BACKGROUND.draw(0, 0, Engine.getWidth(), Engine.getHeight());
		Resources.getImage("color").draw(0, 0, selectionBarSize, Engine.getHeight());

		g.drawImage(hulls[hullI].getSprite(), hullCoords[0], hullCoords[1]);
		g.drawImage(shields[shieldI].getSprite(), shieldCoords[0], shieldCoords[1]);
		g.drawImage(turrets[turretI].getSprite(), turretCoords[0], turretCoords[1]);

		for (int i = 0; i < boxes; i++) {
			upArrows[i].isHovering(mx, my);
			downArrows[i].isHovering(mx, my);
			upArrows[i].render(g);
			downArrows[i].render(g);
		}
		g.drawString(hulls[hullI].getName(), 20, verticalBoxSize / 2 - 10);
		g.drawString(shields[shieldI].getName(), 20, (verticalBoxSize) + verticalBoxSize / 2 - 10);
		g.drawString(engines[engineI].getName(), 20, (2 * verticalBoxSize) + verticalBoxSize / 2 - 10);
		g.drawString(turrets[turretI].getName(), 20, (3 * verticalBoxSize) + verticalBoxSize / 2 - 10);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.NEW_SELECTION;
	}

}
